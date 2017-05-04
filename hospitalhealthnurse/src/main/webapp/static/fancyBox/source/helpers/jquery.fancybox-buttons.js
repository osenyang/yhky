/*
 * Buttons helper for fancyBox
 * version: 1.0.5 (Mon, 15 Oct 2012)
 * @requires fancyBox v2.0 or later
 *
 * Usage:
 *     $(".fancybox").fancybox({
 *         helpers : {
 *             buttons: {
 *                 position : 'top'
 *             }
 *         }
 *     });
 *
 */
(function(B){var A=B.fancybox;A.helpers.buttons={defaults:{skipSingle:false,position:"top",tpl:'<div id="fancybox-buttons"><ul><li><a class="btnPrev" title="Previous" href="javascript:;"></a></li><li><a class="btnPlay" title="Start slideshow" href="javascript:;"></a></li><li><a class="btnNext" title="Next" href="javascript:;"></a></li><li><a class="btnToggle" title="Toggle size" href="javascript:;"></a></li><li><a class="btnClose" title="Close" href="javascript:;"></a></li></ul></div>'},list:null,buttons:null,beforeLoad:function(C,D){if(C.skipSingle&&D.group.length<2){D.helpers.buttons=false;D.closeBtn=true;return}D.margin[C.position==="bottom"?2:0]+=30},onPlayStart:function(){if(this.buttons){this.buttons.play.attr("title","Pause slideshow").addClass("btnPlayOn")}},onPlayEnd:function(){if(this.buttons){this.buttons.play.attr("title","Start slideshow").removeClass("btnPlayOn")}},afterShow:function(C,D){var E=this.buttons;if(!E){this.list=B(C.tpl).addClass(C.position).appendTo("body");E={prev:this.list.find(".btnPrev").click(A.prev),next:this.list.find(".btnNext").click(A.next),play:this.list.find(".btnPlay").click(A.play),toggle:this.list.find(".btnToggle").click(A.toggle),close:this.list.find(".btnClose").click(A.close)}}if(D.index>0||D.loop){E.prev.removeClass("btnDisabled")}else{E.prev.addClass("btnDisabled")}if(D.loop||D.index<D.group.length-1){E.next.removeClass("btnDisabled");E.play.removeClass("btnDisabled")}else{E.next.addClass("btnDisabled");E.play.addClass("btnDisabled")}this.buttons=E;this.onUpdate(C,D)},onUpdate:function(C,D){var E;if(!this.buttons){return}E=this.buttons.toggle.removeClass("btnDisabled btnToggleOn");if(D.canShrink){E.addClass("btnToggleOn")}else{if(!D.canExpand){E.addClass("btnDisabled")}}},beforeClose:function(){if(this.list){this.list.remove()}this.list=null;this.buttons=null}}}(jQuery));