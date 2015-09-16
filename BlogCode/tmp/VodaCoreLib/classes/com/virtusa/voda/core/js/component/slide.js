function sliderComp(context, val){
	var noOfDivs = val?val:4;
	var noOfPanes = $(context).find(".contentItem").length;		
	var mainWidth = $('[id$='+context+'] .sliderPanel').css('width').split('px');
	var pageWidth = Math.round(mainWidth[0]/noOfDivs);		
	var containerWidth = Math.abs($("[id$="+context+"] .contentItem").length*pageWidth);				
	var contWidth = pageWidth;
	var mainContWidth = $('[id$='+context+'] .sliderPanel .contentItem').css('width',pageWidth+"px");		
	$("[id$="+context+"] .containerBox").css('width',containerWidth);
	var mainWidthFinal = Math.abs(noOfDivs*pageWidth);	
	$("[id$="+context+"] .sliderPanel").css('width',mainWidthFinal);
	var rDisable = containerWidth-mainWidthFinal;
	var contLeftPos = Math.abs($('[id$='+context+'] .containerBox').css('margin-left').split('px')[0]);
	checkLeftDisable(contLeftPos,context);
	var bulletCount = Math.ceil(($("[id$="+context+"] .contentItem").length)/noOfDivs);
	if(bulletCount > 1){
		for(var i=0; i< bulletCount; i++){
			$('[id$='+context+'] ul.round').append('<li class="roundItem"></li>');
		}
	}
	$('[id$='+context+'] li.roundItem').eq(0).addClass('active');
	/* Top Previous Button */
	$('[id$='+context+'] .sp').each(function(){	
		var busy = false;
		$(this).click(function(){
			if($(this).hasClass('topLeftDisable')){
			}else{					
				if(busy) return; else busy = true;			
				var cBox = $(this).siblings().find(".containerBox" );
				var mLeft = $(this).siblings().find(".containerBox" ).css('margin-left');
				mLeft = mLeft.split('px');					
				mLeft = Number(mLeft[0])+pageWidth;					
				if(mLeft <= 0){						
					cBox.animate({marginLeft:mLeft+'px'},"fast",'swing', function(){
						var contLeftPos = Math.abs(cBox.css('margin-left').split('px')[0]);								
						checkLeftDisable(contLeftPos,context);
						checkRightDisable(contLeftPos,rDisable,context);
						if(contLeftPos%mainWidthFinal == 0){
							/* rounded circles */
							var pageMoveCount = contLeftPos/mainWidthFinal;							
							var roundPosition = Math.round(pageMoveCount%$('[id$='+context+'] li.roundItem').length);								
							changeActiveClass(roundPosition,context);
						}
						busy = false;	
					});	
				}
			}				
		});
	});
	/* Top Next Button */
	$('[id$='+context+'] .sn').each(function(){
		var busy = false;
		$(this).click(function(e){
			if($(this).hasClass('topRightDisable')){
			}else{
				if(busy) return; else busy = true;
				var clkBtn = $(this); 			
				var cBox = $(this).siblings().find(".containerBox" );
				var mLeft = $(this).siblings().find(".containerBox" ).css('margin-left');			
				mLeft = mLeft.split('px');				
				mLeft = mLeft[0]-pageWidth;									
				if(Math.round(Math.abs(mLeft)) != Math.round(rDisable+pageWidth)){
					cBox.animate({'margin-left':mLeft+'px'},"fast",'linear',function(){						
						var contLeftPos = Math.abs(cBox.css('marginLeft').split('px')[0]);					
						checkLeftDisable(contLeftPos,context);
						checkRightDisable(contLeftPos,rDisable,context);	
						if((contLeftPos%mainWidthFinal == 0) || (Math.abs(contLeftPos) == rDisable)){								
							/* rounded circles */
							var pageMoveCount = contLeftPos/mainWidthFinal;							
							var roundPosition = Math.ceil(pageMoveCount%$('[id$='+context+'] li.roundItem').length);								
							changeActiveClass(roundPosition,context);
						}
						busy = false;
					});				
				}
			}				
		});			
	});
	/* Bottom Previous Button */
	$('[id$='+context+'] .bt-left').click(function(){
		if($(this).hasClass('btLeftDisable')){
		}else{
			var cBOx = $(this).parent().siblings().find('.containerBox');
			var mLeft = $(this).parent().siblings().find('.containerBox').css('margin-left');			
			mLeft = mLeft.split('px');				
			mLeft = Number(mLeft[0])+Number(mainWidthFinal);						
			if(mLeft <= 0){
				cBOx.animate({marginLeft:mLeft+'px'},"fast",'swing',function(){
					var contLeftPos = Math.abs(cBOx.css('margin-left').split('px')[0]);								
					checkLeftDisable(contLeftPos,context);
					checkRightDisable(contLeftPos,rDisable,context);
					/* rounded circles */
					var pageMoveCount = Math.abs(cBOx.css('margin-left').split('px')[0])/mainWidthFinal;							
					var roundPosition = Math.ceil(pageMoveCount%$('[id$='+context+'] li.roundItem').length);
					changeActiveClass(roundPosition,context);
				});					
			}else{
				cBOx.animate({marginLeft:'0px'},"fast",'swing',function(){
					var contLeftPos = Math.abs(cBOx.css('margin-left').split('px')[0]);								
					checkLeftDisable(contLeftPos,context);
					checkRightDisable(contLeftPos,rDisable,context);											
					changeActiveClass(0,context);
				});					
			}
		}			
	});
	/* Bottom Next Button */
	$('[id$='+context+'] .bt-right').click(function(){
		if($(this).hasClass('btRightDisable')){
		}else{
			var cBOx = $(this).parent().siblings().find('.containerBox');
			var leftPos = Number(Math.abs(cBOx.css('margin-left').split('px')[0]))+Number(mainWidthFinal);								
			if((containerWidth-leftPos)> Number(mainWidthFinal)){
				cBOx.animate({marginLeft:"-"+leftPos+'px'},"fast",'swing',function(){
					var contLeftPos = Math.abs(cBOx.css('margin-left').split('px')[0]);													
					checkLeftDisable(contLeftPos,context);
					checkRightDisable(contLeftPos,rDisable,context);
					/* rounded circles */
					var pageMoveCount = Math.abs(cBOx.css('margin-left').split('px')[0])/mainWidthFinal;							
					var roundPosition = Math.ceil(pageMoveCount%$('[id$='+context+'] li.roundItem').length);
					changeActiveClass(roundPosition,context);
					
				});	
			}else{			
				var left = Math.abs(cBOx.css('margin-left').split('px')[0]);
				left = left +(containerWidth-leftPos); 					
				cBOx.animate({marginLeft:"-"+left+'px'},"fast",'swing',function(){
					var contLeftPos = Math.abs(cBOx.css('margin-left').split('px')[0]);								
					checkLeftDisable(contLeftPos,context);
					checkRightDisable(contLeftPos,rDisable,context);
					var roundPosition = Math.ceil($('[id$='+context+'] li.roundItem').length-1);						
					changeActiveClass(roundPosition,context);
				});
			}
		}
	});		
}
function checkLeftDisable(contLeftPos,context){
	if(contLeftPos == 0){				
		$('[id$='+context+'] .sp').addClass('topLeftDisable');
		$('[id$='+context+'] .bt-left').addClass('btLeftDisable');
	}else{				
		$('[id$='+context+'] .sp').removeClass('topLeftDisable');
		$('[id$='+context+'] .bt-left').removeClass('btLeftDisable');
	}
}
function checkRightDisable(contLeftPos,rDisable,context){
	if(contLeftPos == rDisable){				
		$('[id$='+context+'] .sn').addClass('topRightDisable');
		$('[id$='+context+'] .bt-right').addClass('btRightDisable');
	}else{
		$('[id$='+context+'] .sn').removeClass('topRightDisable');
		$('[id$='+context+'] .bt-right').removeClass('btRightDisable');
	}
}
function changeActiveClass(roundPosition,context){			
	$('[id$='+context+'] li.roundItem').removeClass('active');
	$('[id$='+context+'] li.roundItem').eq(roundPosition).addClass('active');
}