AdfRichUIPeer.createPeerClass(AdfRichUIPeer, "VodaSliderPeer", true);
VodaSliderPeer.InitSubclass = function () {
    AdfRichUIPeer.addComponentEventHandlers(this, AdfUIInputEvent.CLICK_EVENT_TYPE);
}

//VodaSliderPeer.prototype.HandleComponentClick = function (componentEvent) {
//    if (componentEvent.isLeftButtonPressed()) {
//        var component = this.getComponent();
//        AdfAssert.assertPrototype(component, VodaSlider);
//        var target = componentEvent.getNativeEventTarget();
//        if (target && target.tagName == "A") {
//            var tag = target.firstChild.nodeValue;
//            AdfAssert.assertString(tag);
//            //            VodaTagSelectEvent.queue(component, tag);
//            componentEvent.cancel();
//        }
//    }
//}
// Register the peer with the component. This bit of script must
// be invoked after the VodaSlider and VodaTagSelectEvent objects
// are created. This is enforced by the ordering of the script files
// in the oracle.asfdemo.Voda.faces.resource.VodaResourceLoader.VodaScriptsResourceLoader.
AdfPage.PAGE.getLookAndFeel().registerPeerConstructor("com.virtusa.voda.core.Slider", "VodaSliderPeer");