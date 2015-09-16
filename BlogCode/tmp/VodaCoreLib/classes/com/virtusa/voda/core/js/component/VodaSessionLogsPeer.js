AdfRichUIPeer.createPeerClass(AdfRichUIPeer, "VodaSessionLogsPeer", true);
VodaSessionLogsPeer.InitSubclass = function () {
    AdfRichUIPeer.addComponentEventHandlers(this, AdfUIInputEvent.CLICK_EVENT_TYPE);
}

VodaSessionLogsPeer.prototype.HandleComponentClick = function (componentEvent) {
    if (componentEvent.isLeftButtonPressed()) {
        var component = this.getComponent();
        AdfAssert.assertPrototype(component, VodaSessionLogs);
        var target = componentEvent.getNativeEventTarget();
        if (target && target.tagName == "DIV") {
            if($(target) && $(target).hasClass('dataFilter')){
                var dataFilter =$(target).attr('value');
                AdfAssert.assertString(dataFilter);
                VodaSessionLogsDataFilterSelectEvent.queue(component, dataFilter);
                componentEvent.cancel();
             }
            if($(target) && $(target).hasClass('timeFrame')){
                var timeFrame =$(target).hasClass('left');
                AdfAssert.assertString(timeFrame);
                VodaSessionLogsTimeFrameSelectEvent.queue(component, timeFrame);
                componentEvent.cancel();
             }
            if($(target) && $(target).hasClass('timeScale')){
                var timeScale =$(target).attr('value');
                AdfAssert.assertString(timeScale);
                VodaSessionLogsTimeScaleSelectEvent.queue(component, timeScale);
                componentEvent.cancel();
             }
        }
    }
}
// Register the peer with the component. This bit of script must
// be invoked after the VodaSlider and VodaTagSelectEvent objects
// are created. This is enforced by the ordering of the script files
// in the oracle.asfdemo.Voda.faces.resource.VodaResourceLoader.VodaScriptsResourceLoader.
AdfPage.PAGE.getLookAndFeel().registerPeerConstructor("com.virtusa.voda.core.SessionLogs", "VodaSessionLogsPeer");