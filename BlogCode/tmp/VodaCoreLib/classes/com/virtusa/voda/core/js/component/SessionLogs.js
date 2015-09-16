(function($) {
    $.graph={
    defaults:{
        eventStatus : 'all',
        timeUnit:'hours',
        setSliderHours:0
    }
    };
   function compInitate(options,data,elem){        
    var settings = $.extend({},$.graph.defaults,options);   
    var $this=elem;
    var mainObj={
        minsArr : [],//[0,10,20,30,40,50,100,110,120,130,140,150,200],
        secsArr : [0,30,100,130,200,230,300,330,400,430,500,530,600],
        liArr : [],
        
        /*
        ** reference to DOM elements
        */
        generateDOMRef :function(){
            this.chrt=$($this).find('.chrt');
            this.header=$($this).find('.graphheader');
            this.headerInner=$($this).find('.header-inner');    
            this.hoursHeader=$($this).find('.hoursHeader');
            this.minsHeader=$($this).find('.minsHeader');
            this.secsHeader=$($this).find('.secsHeader');
            this.sliderWrapper=$($this).find('.wrapper');
            this.minsHeaderScroller=$($this).find('.minsHeader-scroller');
            this.secsHeaderScroller=$($this).find('.secsHeader-scroller');
            if(!$($this).hasClass('rendered'))
            { 
                (this.generateHours()).appendTo([this.hoursHeader,this.sliderWrapper]);
                this.generateGridlines(); 
                
                for(i=0;i<25;i++){
                    $($this).find('.wrapper li:eq('+i+')').css('left',(i*27)+5);
            } 
            }
            
        },
        /*
        ** create grid lines for graph
        */
        generateGridlines:function(){
            this.chrt.append($('<div class="gridLinesHeader"></div>'));
            for(var i=0;i<24;i++)
            {
                this.chrt.find('.gridLinesHeader').append($('<span class="gridlines" ></span>'));
            }        
            
        },
        
        /*
        ** Initialization of component
        */
        init:function(graphData,elem){
            
            mainObj.elem=elem;
            mainObj.generateDOMRef();
            mainObj.initiateSliders();
            mainObj.registerEvents();
            this.headerInner.width(this.header.width());        
    //        this.headerInner.height(this.chrt.height()+2);
            this.sliderWrapper.hide();
            if(!$($this).hasClass('rendered'))
            {
            mainObj.generateMinutesHeader(0);
            mainObj.generateSecondsHeader(0);
            mainObj.convertTime(graphData.obj1);
            }
            mainObj.configureGraph(settings);
        },
        
        /*
        ** minutes header 
        */
        generateMinutesHeader:function(initialValue)
        {
            var tempVal;
            var list=this.minsHeader.find('ul');
            var len=this.minsArr.length;
            list.empty();
            for(var i=0;i<len;i++)
            {
                tempVal=('000'+(this.minsArr[i]+initialValue)).slice(-4);
                this.liArr[i]=tempVal.slice(0,2)+':'+tempVal.slice(2,4);
                list.append($('<li>'+this.liArr[i]+'</li>'));
            }
        },
            
        /*
        ** seconds header 
        */
        generateSecondsHeader:function(initialValue)
        {
            var tempVal;
            var list=this.secsHeader.find('ul');
            var len=this.secsArr.length;
            list.empty();
            for(var i=0;i<len;i++)
            {
                var minCorrection=(this.secsArr[i]+initialValue);
                minCorrection=(minCorrection%100 == 60)?minCorrection+40:minCorrection;
                if(i==this.secsArr.length-1 && (minCorrection%10000)>=6000)    
                    minCorrection+=4000;
                
                tempVal=('00000'+minCorrection).slice(-6);                
                this.liArr[i]=tempVal.slice(0,2)+':'+tempVal.slice(2,4)+':'+tempVal.slice(4,6);
                list.append($('<li>'+this.liArr[i]+'</li>'));
            }
        },   

        /*
        ** hours header 
        */
        generateHours:function()
        {
            var list=$('<ul></ul>');
            for(var i=0;i<25;i++)
                list.append($('<li>'+('0'+i).slice(-2)+'</li>'));

            return list;
        },
        
        createGraph:function(obj)
        {
            var len=obj.length;
            for(var i=0;i<len;i++)
            {            
                var totalHrs=0; 
                var objLen=Object.keys(obj[i]).length;
                if(objLen!=0 && obj[i].hasOwnProperty('statusList'))
                {
                    var len1=obj[i].statusList.length;
                    for(var j=0;j<len1;j++)
                    {
                        totalHrs+=obj[i].statusList[j].hours;                    
                    }
                    if(totalHrs<=24)
                    {
                        (function(i)
                        {
                            mainObj.createRow(obj[i]);   
                    $($this).find('.row > div').off('click').on('click',function(){ mainObj.createPopup($(this).data('storeData'),$(this).parents('.row-container').position());  
                                                                      });
                        })(i);
                    }
                }
            }
            $($this).find('.gridLinesHeader').height(24*obj.length);
            $($this).addClass('rendered');
        },
        
        createRow:function(obj)
        {
            var rowContainer=$('<div class="row-container"><div class="rowDate label-field">'+obj.label+'</div></div>');
            var row=$('<div class="row"></span></div>');
            var len=obj.statusList.length;
            for(i=0;i<len;i++)
            {
                var wid=(obj.statusList[i].hours/24)*100;
                row.append($('<div class='+obj.statusList[i].status+' style="width:'+wid+'%"></div>').data('storeData',obj.statusList[i]));
            }       

            rowContainer.append(row);
            mainObj.headerInner.append(rowContainer);
            $($this).find('.gridlines').height($($this).find('.header-inner').height());
        },             
        
        /*
        ** popup modal
        */
        createPopup:function(dataObj,pos)
        {
            $($this).find('.popup').remove(); 
            var popUpContainer=$('<div class="popup popup-'+dataObj['status']+'"></div>');
            var popContent=$('<div class="pop-content"></div>');
            var popHeader=$('<div class="pop-header"><span class="SELogs_status_'+dataObj['status']+'"></span>'+dataObj['status']+'<span class="close">x</span></div>');
            for(var prop in dataObj['miscData'])
            {
                popContent.append($('<div><span class="propName">'+prop+'</span><span class="propValue">'+dataObj['miscData'][prop]+'</span></div>'));
            }
            if(Object.keys(dataObj['miscData']).length==0)
            {
                popContent.append($('<div>No Information is available</div>'));
            }
            popUpContainer.append(popHeader).append(popContent).append('<div class="arrow"></div>');
            $($this).find('.header-inner').append(popUpContainer);
            $('.arrow').css('top',pos.top); 
            $('.close').on('click',function(){
                $(this).parents('.popup').remove();
            });
            popUpContainer.css('top',$($this).find('.chrt').scrollTop()+20); 
        },
    
    /*
    ** Change seconds header value
    */
        chgeSecsHeader:function(val,slider)
        {
            var scrollerValue = (Math.floor(val/2)*100) + ((val%2)*30);
            mainObj.generateSecondsHeader(((10000*slider) + scrollerValue),((val%2)!==0));
        },
        
        calMinArr:function(mins,start)
        {
            var total,rem=0,count=0,j;
            j=start;
            total=j*100+(Math.ceil(j*60 / mins) * mins % 60);
            this.minsInput=mins;
            this.minsArr=[total];
            while(count<12)
            {
                total=total+mins;         
                if((total<(j*100+60)))
                {   
                    this.minsArr.push(total);
                }
                else
                {
                    j=j+1;
                    rem=(Math.ceil(j*60 / mins) * mins % 60);
                    total=j*100+rem; 
                    this.minsArr.push(total); 
                }
                count=count+1;
            }
            this.minStep=this.minsArr[this.minsArr.length-1]/100;       
        },
    
        moveSlider:function(slider,moveX){
            var units=parseInt(slider.position().left/27)+moveX;
            units=mainObj.checkBoundary(slider,units*27);
            slider.css('left',units);              
            units=units/27;
            $($this).find('.right,.left').data('hrVal',units);
            $($this).find('.wrapper li').removeClass('active');        
            if(slider.parent().hasClass('minsHeader-scroller'))
            {
                $($this).find('.wrapper li:eq('+units+'),.wrapper li:eq('+(units+1)+'),.wrapper li:eq('+(units+2)+')').addClass('active');
                $($this).find('.row').css('right',$($this).find('.row-container').width()*((Math.ceil(units*60 / mainObj.minsInput)/12 )));
                mainObj.calMinArr(mainObj.minsInput,units);
                mainObj.generateMinutesHeader(0);            
            }
            else
            {
                $($this).find('.wrapper li:eq('+units+'),.wrapper li:eq('+(units+1)+')').addClass('active');
                $($this).find('.row').css('right',$($this).find('.row-container').width()*(units));
                mainObj.chgeSecsHeader(mainObj.header.scrollLeft()/60,units);
                mainObj.header.scrollLeft(0);
            }
            $($this).find('.secsScroller').scrollLeft(0);
        },
        

        checkBoundary:function(slider,val){
            var boundary;
            var max=slider.parent().width()-slider.width();
            if(val<0)
               boundary=0;
            else if(val>max) 
               boundary=max; 
            else
               boundary=val;
            return boundary;
        },
        
        initiateSliders:function(){
    /*
    ** Hours RangeSlider for Minutes & Seconds time units
    */
            
            generateSlider('.minsHeader',(mainObj.minStep+1));
            generateSlider('.secsHeader',2);
            
            function generateSlider(element,widthFactor) {
                $($this).find(element + '-scroller .handle').draggable({
                    containment: "parent",
                    create:function( event, ui){
                        $(this).width(27*widthFactor);
                    }
//                    drag: function( event, ui )                   
//                    { 
//                        mainObj.moveSlider($(this),0);
//                    }
                });
              $($this).find(element + '-scroller .handle').on( "drag", function( event, ui ) {
              mainObj.moveSlider($(this),0);
              } )
            }
        },
        
        calMinSpan:function()
        {
            var bound=this.minsArr[this.minsArr.length-1];
            var totalMins=(Math.floor(bound/100)*60)+bound%100;
            return 1440/totalMins;
        },   
        
        toggleStatusButton:function(elem)
        {
                $($this).find('.popup').remove(); 
                $($this).find('.control-status .button').removeClass('selected');
                $($this).find('.control-status .button.'+elem).toggleClass('selected');
                $($this).find('.row .active,.row .denied,.row .terminated').css('visibility','hidden');
                $($this).find('.row .'+elem+'').css('visibility','visible');
                if(elem=='all')
                {
                    $($this).find('.row .active,.row .terminated,.row .denied').css('visibility','visible');
                }
        },
        
        toggleTimeUnitButton:function(elem)
        {
        $($this).find('.popup').remove(); 
            var headerWidth=mainObj.header.width();
                var secsHorizontalScroll=$($this).find('.secsScroller');
                $($this).find('.control-time .button').removeClass('selected');
                $($this).find('.control-time .button.'+elem).toggleClass('selected');
                $($this).find('.units').text(elem);
                $($this).find('.timeUnit').hide();
                mainObj.minsHeaderScroller.hide();
                mainObj.secsHeaderScroller.hide();
                $($this).find('#graph-table > p:last-child').show();
                mainObj.sliderWrapper.show();
                $($this).find('.row').css('right','0');
                $($this).find('.handle').css('left','0');
                $($this).find('.wrapper li').removeClass('active');
                $($this).find('.wrapper li:eq(0),.wrapper li:eq(1)').addClass('active');
                secsHorizontalScroll.hide();
                if(elem=='hours')
                {   
                    $($this).find('.graphheader .row').width(headerWidth);
                    mainObj.headerInner.width(headerWidth);
                    $($this).find('#graph-table > p:last-child').hide();           
                    mainObj.hoursHeader.show();
                    mainObj.sliderWrapper.hide();
                }
                else if(elem=='minutes')
                {     
                    $($this).find('.graphheader .row').width(headerWidth*12);
                    mainObj.headerInner.width(headerWidth);
                    mainObj.minsHeader.show();    
                    mainObj.minsHeaderScroller.show();            
                    $($this).find('.wrapper li:eq(2)').addClass('active');
                }
                else 
                {
                    secsHorizontalScroll.show();
                    $($this).find('.graphheader .row').width(headerWidth*240);
                    mainObj.headerInner.width(headerWidth*10);
                    mainObj.secsHeader.show();
                    mainObj.secsHeaderScroller.show();            
                }
        },
        
        setSlider:function(val)
        {
            if($($this).find('.minsHeader-scroller').is(':visible'))
                {                      
                    mainObj.moveSlider($($this).find('.minsHeader-scroller .handle'),val);   
                }
                else
                { 
                    mainObj.moveSlider($($this).find('.secsHeader-scroller .handle'),val);
                }   
        },
        
        /****   Events   ****/
        registerEvents:function(){
    /*
    **  Button controls for time units (hours,minutes,seconds)   
    */
            
            $($this).find('.control-time .button').on('click',function(){
                var ctrlTimeUnit=$(this)[0].className.split(" ")[1];
                mainObj.toggleTimeUnitButton(ctrlTimeUnit);
            });
    
        
    /*
    ** Button controls for event status
    */
    
            $($this).find('.control-status .button').on('click',function(){
                var ctrlStatus=$(this)[0].className.split(" ")[1];  
                mainObj.toggleStatusButton(ctrlStatus);
            });
    
    /*
    ** horizontal scrollbar for Seconds time units
    */
            $($this).find('.graphheader').on('scroll',function(e){        
                this.scrollLeft = parseInt(this.scrollLeft / 60)* 60;
                var unit=this.scrollLeft/60;    
                mainObj.chgeSecsHeader(unit,parseInt($($this).find(".secsHeader-scroller .handle").position().left/27));          
            });
            $($this).find(".secsScroller").scroll(function(){
                $($this).find(".graphheader").scrollLeft($($this).find(".secsScroller").scrollLeft());
            });
    
    /*
    ** Left and Right buttons in range slider
    **/
            $($this).find('.wrapper .right,.wrapper .left').click(function()            {
                var direction;
                direction=($(this).hasClass('right'))?1:-1;   
                mainObj.setSlider(direction); 
            });          
        },
        convertTime:function(obj)
        {
            for(var prop in obj)
            {
                var objLen=Object.keys(obj[prop]).length;
                if(objLen!=0 && obj[prop].hasOwnProperty('statusList'))
                {
                    var len=obj[prop].statusList.length;
                    for(var i=0;i<len;i++)
                    {
                        starttime=0,endtime=0;
                        starttime=new Date(obj[prop].statusList[i].startTime).getTime();
                        endtime=new Date(obj[prop].statusList[i].endTime).getTime();
                        var convertor=3600000;
                        obj[prop].statusList[i].hours=(endtime-starttime)/convertor;
                    }                                     
                 }
            }
            mainObj.createGraph(obj);
        },     
    configureGraph:function(settings){
            if((settings.eventStatus=='all' || settings.eventStatus=='active' || settings.eventStatus=='terminated' || settings.eventStatus=='denied') && (settings.timeUnit=='hours' || settings.timeUnit=='minutes' || settings.timeUnit=='seconds') && (settings.setSliderHours >= 0 || settings.setSliderHours < 25 ))
            {
                mainObj.toggleTimeUnitButton(settings.timeUnit);
                mainObj.toggleStatusButton(settings.eventStatus );
                if(settings.timeUnit!='hours')
                    mainObj.setSlider(settings.setSliderHours);
            }
        }
    };        
        mainObj.calMinArr(10,0);
        mainObj.init(data,elem);
        return mainObj.configureGraph;
    }
    $.fn.graphComp=function(data,options){
        if(!options) {            
            options = {}
        }
        $(this).config=compInitate(options,data,this); 
        return $(this);        
    };
    
})(jQuery);
