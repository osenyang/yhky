/* Copyright (c) 2011 Brandon Aaron (http://brandonaaron.net)
 * Licensed under the MIT License (LICENSE.txt).
 *
 * Thanks to: http://adomas.org/javascript-mouse-wheel/ for some pointers.
 * Thanks to: Mathias Bank(http://www.mathias-bank.de) for a scope bug fix.
 * Thanks to: Seamus Leahy for adding deltaX and deltaY
 *
 * Version: 3.0.6
 * 
 * Requires: 1.2.2+
 */
(function(B){function C(I){var G=I||window.event,H=[].slice.call(arguments,1),J=0,F=0,E=0,I=B.event.fix(G);I.type="mousewheel";G.wheelDelta&&(J=G.wheelDelta/120);G.detail&&(J=-G.detail/3);E=J;G.axis!==void 0&&G.axis===G.HORIZONTAL_AXIS&&(E=0,F=-1*J);G.wheelDeltaY!==void 0&&(E=G.wheelDeltaY/120);G.wheelDeltaX!==void 0&&(F=-1*G.wheelDeltaX/120);H.unshift(I,J,F,E);return(B.event.dispatch||B.event.handle).apply(this,H)}var D=["DOMMouseScroll","mousewheel"];if(B.event.fixHooks){for(var A=D.length;A;){B.event.fixHooks[D[--A]]=B.event.mouseHooks}}B.event.special.mousewheel={setup:function(){if(this.addEventListener){for(var E=D.length;E;){this.addEventListener(D[--E],C,false)}}else{this.onmousewheel=C}},teardown:function(){if(this.removeEventListener){for(var E=D.length;E;){this.removeEventListener(D[--E],C,false)}}else{this.onmousewheel=null}}};B.fn.extend({mousewheel:function(E){return E?this.bind("mousewheel",E):this.trigger("mousewheel")},unmousewheel:function(E){return this.unbind("mousewheel",E)}})})(jQuery);