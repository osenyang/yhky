/*
 * Thumbnail helper for fancyBox
 * version: 1.0.7 (Mon, 01 Oct 2012)
 * @requires fancyBox v2.0 or later
 *
 * Usage:
 *     $(".fancybox").fancybox({
 *         helpers : {
 *             thumbs: {
 *                 width  : 50,
 *                 height : 50
 *             }
 *         }
 *     });
 *
 */
(function(B){var A=B.fancybox;A.helpers.thumbs={defaults:{width:50,height:50,position:"bottom",source:function(D){var C;if(D.element){C=B(D.element).find("img").attr("src")}if(!C&&D.type==="image"&&D.href){C=D.href}return C}},wrap:null,list:null,width:0,init:function(G,I){var F=this,D,C=G.width,J=G.height,E=G.source;D="";for(var H=0;H<I.group.length;H++){D+='<li><a style="width:'+C+"px;height:"+J+'px;" href="javascript:jQuery.fancybox.jumpto('+H+');"></a></li>'}this.wrap=B('<div id="fancybox-thumbs"></div>').addClass(G.position).appendTo("body");this.list=B("<ul>"+D+"</ul>").appendTo(this.wrap);B.each(I.group,function(L){var K=E(I.group[L]);if(!K){return}B("<img />").load(function(){var P=this.width,M=this.height,N,O,Q;if(!F.list||!P||!M){return}N=P/C;O=M/J;Q=F.list.children().eq(L).find("a");if(N>=1&&O>=1){if(N>O){P=Math.floor(P/O);M=J}else{P=C;M=Math.floor(M/N)}}B(this).css({width:P,height:M,top:Math.floor(J/2-M/2),left:Math.floor(C/2-P/2)});Q.width(C).height(J);B(this).hide().appendTo(Q).fadeIn(300)}).attr("src",K)});this.width=this.list.children().eq(0).outerWidth(true);this.list.width(this.width*(I.group.length+1)).css("left",Math.floor(B(window).width()*0.5-(I.index*this.width+this.width*0.5)))},beforeLoad:function(C,D){if(D.group.length<2){D.helpers.thumbs=false;return}D.margin[C.position==="top"?0:2]+=((C.height)+15)},afterShow:function(C,D){if(this.list){this.onUpdate(C,D)}else{this.init(C,D)}this.list.children().removeClass("active").eq(D.index).addClass("active")},onUpdate:function(C,D){if(this.list){this.list.stop(true).animate({"left":Math.floor(B(window).width()*0.5-(D.index*this.width+this.width*0.5))},150)}},beforeClose:function(){if(this.wrap){this.wrap.remove()}this.wrap=null;this.list=null;this.width=0}}}(jQuery));