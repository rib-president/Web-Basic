/*! For license information please see server.js.LICENSE.txt */
(()=>{"use strict";var e,t={701:(e,t,r)=>{r.d(t,{ZP:()=>i,lm:()=>u,p9:()=>a});var n=r(689),o=(0,n.createContext)(null);const i=o;var a=function(e){var t=e.resolve,r=(0,n.useContext)(o);return r?(r.done||r.promises.push(Promise.resolve(t())),null):null},u=function(e){var t=(0,n.useContext)(o);return t?t.done?null:void t.promises.push(Promise.resolve(e())):null}},821:(e,t,r)=>{r.d(t,{ZP:()=>L,PR:()=>b,Rf:()=>E,HD:()=>P});var n=r(2);function o(e,t,r){return(t=function(e){var t=function(e,t){if("object"!==(0,n.Z)(e)||null===e)return e;var r=e[Symbol.toPrimitive];if(void 0!==r){var o=r.call(e,"string");if("object"!==(0,n.Z)(o))return o;throw new TypeError("@@toPrimitive must return a primitive value.")}return String(e)}(e);return"symbol"===(0,n.Z)(t)?t:String(t)}(t))in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function i(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function a(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?i(Object(r),!0).forEach((function(t){o(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):i(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}var u=r(165),c=r(861);const s=require("axios");var l=r.n(s),f=r(477),p=(0,u.Z)().mark(O),h=(0,u.Z)().mark(P),d="users/GET_USERS_PENDING",v="users/GET_USERS_SUCCESS",y="users/GET_USERS_FAILURE",m="users/GET_USER",g="users/GET_USER_SUCCESS",x="users/GET_USER_FAILURE",b=function(e){return{type:m,payload:e}},w=function(e){return{type:g,payload:e}},j=function(e){return{type:x,payload:e,error:!0}},E=function(){return function(){var e=(0,c.Z)((0,u.Z)().mark((function e(t){var r;return(0,u.Z)().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,t({type:d}),e.next=4,l().get("https://jsonplaceholder.typicode.com/users");case 4:r=e.sent,t({type:v,payload:r}),e.next=12;break;case 8:throw e.prev=8,e.t0=e.catch(0),t((n=e.t0,{type:y,error:!0,payload:n})),e.t0;case 12:case"end":return e.stop()}var n}),e,null,[[0,8]])})));return function(t){return e.apply(this,arguments)}}()},S=function(e){return l().get("https://jsonplaceholder.typicode.com/users/".concat(e))};function O(e){var t;return(0,u.Z)().wrap((function(r){for(;;)switch(r.prev=r.next){case 0:return r.prev=0,r.next=3,(0,f.call)(S,e.payload);case 3:return t=r.sent,r.next=6,(0,f.put)(w(t.data));case 6:r.next=12;break;case 8:return r.prev=8,r.t0=r.catch(0),r.next=12,(0,f.put)(j(r.t0));case 12:case"end":return r.stop()}}),p,null,[[0,8]])}function P(){return(0,u.Z)().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,(0,f.takeEvery)(m,O);case 2:case"end":return e.stop()}}),h)}var _={users:null,user:null,loading:{users:!1,user:!1},error:{users:null,user:null}};const L=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:_,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case d:return a(a({},e),{},{loading:a(a({},e.loading),{},{users:!0})});case v:return a(a({},e),{},{users:t.payload.data,loading:a(a({},e.loading),{},{users:!1})});case y:return a(a({},e),{},{loading:a(a({},e.loading),{},{users:!1}),error:a(a({},e.error),{},{users:t.payload})});case m:return a(a({},e),{},{loading:a(a({},e.loading),{},{user:!0}),error:a(a({},e.error),{},{user:null})});case g:return a(a({},e),{},{loading:a(a({},e.loading),{},{user:!1}),user:t.payload});case x:return a(a({},e),{},{loading:a(a({},e.loading),{},{user:!1}),error:a(a({},e.error),{},{user:t.payload})});default:return e}}},689:e=>{e.exports=require("react")},22:e=>{e.exports=require("react-redux")},661:e=>{e.exports=require("react-router-dom")},997:e=>{e.exports=require("react/jsx-runtime")},477:e=>{e.exports=require("redux-saga/effects")},861:(e,t,r)=>{function n(e,t,r,n,o,i,a){try{var u=e[i](a),c=u.value}catch(e){return void r(e)}u.done?t(c):Promise.resolve(c).then(n,o)}function o(e){return function(){var t=this,r=arguments;return new Promise((function(o,i){var a=e.apply(t,r);function u(e){n(a,o,i,u,c,"next",e)}function c(e){n(a,o,i,u,c,"throw",e)}u(void 0)}))}}r.d(t,{Z:()=>o})},165:(e,t,r)=>{r.d(t,{Z:()=>o});var n=r(2);function o(){o=function(){return e};var e={},t=Object.prototype,r=t.hasOwnProperty,i=Object.defineProperty||function(e,t,r){e[t]=r.value},a="function"==typeof Symbol?Symbol:{},u=a.iterator||"@@iterator",c=a.asyncIterator||"@@asyncIterator",s=a.toStringTag||"@@toStringTag";function l(e,t,r){return Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}),e[t]}try{l({},"")}catch(e){l=function(e,t,r){return e[t]=r}}function f(e,t,r,n){var o=t&&t.prototype instanceof d?t:d,a=Object.create(o.prototype),u=new _(n||[]);return i(a,"_invoke",{value:E(e,r,u)}),a}function p(e,t,r){try{return{type:"normal",arg:e.call(t,r)}}catch(e){return{type:"throw",arg:e}}}e.wrap=f;var h={};function d(){}function v(){}function y(){}var m={};l(m,u,(function(){return this}));var g=Object.getPrototypeOf,x=g&&g(g(L([])));x&&x!==t&&r.call(x,u)&&(m=x);var b=y.prototype=d.prototype=Object.create(m);function w(e){["next","throw","return"].forEach((function(t){l(e,t,(function(e){return this._invoke(t,e)}))}))}function j(e,t){function o(i,a,u,c){var s=p(e[i],e,a);if("throw"!==s.type){var l=s.arg,f=l.value;return f&&"object"==(0,n.Z)(f)&&r.call(f,"__await")?t.resolve(f.__await).then((function(e){o("next",e,u,c)}),(function(e){o("throw",e,u,c)})):t.resolve(f).then((function(e){l.value=e,u(l)}),(function(e){return o("throw",e,u,c)}))}c(s.arg)}var a;i(this,"_invoke",{value:function(e,r){function n(){return new t((function(t,n){o(e,r,t,n)}))}return a=a?a.then(n,n):n()}})}function E(e,t,r){var n="suspendedStart";return function(o,i){if("executing"===n)throw new Error("Generator is already running");if("completed"===n){if("throw"===o)throw i;return{value:void 0,done:!0}}for(r.method=o,r.arg=i;;){var a=r.delegate;if(a){var u=S(a,r);if(u){if(u===h)continue;return u}}if("next"===r.method)r.sent=r._sent=r.arg;else if("throw"===r.method){if("suspendedStart"===n)throw n="completed",r.arg;r.dispatchException(r.arg)}else"return"===r.method&&r.abrupt("return",r.arg);n="executing";var c=p(e,t,r);if("normal"===c.type){if(n=r.done?"completed":"suspendedYield",c.arg===h)continue;return{value:c.arg,done:r.done}}"throw"===c.type&&(n="completed",r.method="throw",r.arg=c.arg)}}}function S(e,t){var r=t.method,n=e.iterator[r];if(void 0===n)return t.delegate=null,"throw"===r&&e.iterator.return&&(t.method="return",t.arg=void 0,S(e,t),"throw"===t.method)||"return"!==r&&(t.method="throw",t.arg=new TypeError("The iterator does not provide a '"+r+"' method")),h;var o=p(n,e.iterator,t.arg);if("throw"===o.type)return t.method="throw",t.arg=o.arg,t.delegate=null,h;var i=o.arg;return i?i.done?(t[e.resultName]=i.value,t.next=e.nextLoc,"return"!==t.method&&(t.method="next",t.arg=void 0),t.delegate=null,h):i:(t.method="throw",t.arg=new TypeError("iterator result is not an object"),t.delegate=null,h)}function O(e){var t={tryLoc:e[0]};1 in e&&(t.catchLoc=e[1]),2 in e&&(t.finallyLoc=e[2],t.afterLoc=e[3]),this.tryEntries.push(t)}function P(e){var t=e.completion||{};t.type="normal",delete t.arg,e.completion=t}function _(e){this.tryEntries=[{tryLoc:"root"}],e.forEach(O,this),this.reset(!0)}function L(e){if(e){var t=e[u];if(t)return t.call(e);if("function"==typeof e.next)return e;if(!isNaN(e.length)){var n=-1,o=function t(){for(;++n<e.length;)if(r.call(e,n))return t.value=e[n],t.done=!1,t;return t.value=void 0,t.done=!0,t};return o.next=o}}return{next:k}}function k(){return{value:void 0,done:!0}}return v.prototype=y,i(b,"constructor",{value:y,configurable:!0}),i(y,"constructor",{value:v,configurable:!0}),v.displayName=l(y,s,"GeneratorFunction"),e.isGeneratorFunction=function(e){var t="function"==typeof e&&e.constructor;return!!t&&(t===v||"GeneratorFunction"===(t.displayName||t.name))},e.mark=function(e){return Object.setPrototypeOf?Object.setPrototypeOf(e,y):(e.__proto__=y,l(e,s,"GeneratorFunction")),e.prototype=Object.create(b),e},e.awrap=function(e){return{__await:e}},w(j.prototype),l(j.prototype,c,(function(){return this})),e.AsyncIterator=j,e.async=function(t,r,n,o,i){void 0===i&&(i=Promise);var a=new j(f(t,r,n,o),i);return e.isGeneratorFunction(r)?a:a.next().then((function(e){return e.done?e.value:a.next()}))},w(b),l(b,s,"Generator"),l(b,u,(function(){return this})),l(b,"toString",(function(){return"[object Generator]"})),e.keys=function(e){var t=Object(e),r=[];for(var n in t)r.push(n);return r.reverse(),function e(){for(;r.length;){var n=r.pop();if(n in t)return e.value=n,e.done=!1,e}return e.done=!0,e}},e.values=L,_.prototype={constructor:_,reset:function(e){if(this.prev=0,this.next=0,this.sent=this._sent=void 0,this.done=!1,this.delegate=null,this.method="next",this.arg=void 0,this.tryEntries.forEach(P),!e)for(var t in this)"t"===t.charAt(0)&&r.call(this,t)&&!isNaN(+t.slice(1))&&(this[t]=void 0)},stop:function(){this.done=!0;var e=this.tryEntries[0].completion;if("throw"===e.type)throw e.arg;return this.rval},dispatchException:function(e){if(this.done)throw e;var t=this;function n(r,n){return a.type="throw",a.arg=e,t.next=r,n&&(t.method="next",t.arg=void 0),!!n}for(var o=this.tryEntries.length-1;o>=0;--o){var i=this.tryEntries[o],a=i.completion;if("root"===i.tryLoc)return n("end");if(i.tryLoc<=this.prev){var u=r.call(i,"catchLoc"),c=r.call(i,"finallyLoc");if(u&&c){if(this.prev<i.catchLoc)return n(i.catchLoc,!0);if(this.prev<i.finallyLoc)return n(i.finallyLoc)}else if(u){if(this.prev<i.catchLoc)return n(i.catchLoc,!0)}else{if(!c)throw new Error("try statement without catch or finally");if(this.prev<i.finallyLoc)return n(i.finallyLoc)}}}},abrupt:function(e,t){for(var n=this.tryEntries.length-1;n>=0;--n){var o=this.tryEntries[n];if(o.tryLoc<=this.prev&&r.call(o,"finallyLoc")&&this.prev<o.finallyLoc){var i=o;break}}i&&("break"===e||"continue"===e)&&i.tryLoc<=t&&t<=i.finallyLoc&&(i=null);var a=i?i.completion:{};return a.type=e,a.arg=t,i?(this.method="next",this.next=i.finallyLoc,h):this.complete(a)},complete:function(e,t){if("throw"===e.type)throw e.arg;return"break"===e.type||"continue"===e.type?this.next=e.arg:"return"===e.type?(this.rval=this.arg=e.arg,this.method="return",this.next="end"):"normal"===e.type&&t&&(this.next=t),h},finish:function(e){for(var t=this.tryEntries.length-1;t>=0;--t){var r=this.tryEntries[t];if(r.finallyLoc===e)return this.complete(r.completion,r.afterLoc),P(r),h}},catch:function(e){for(var t=this.tryEntries.length-1;t>=0;--t){var r=this.tryEntries[t];if(r.tryLoc===e){var n=r.completion;if("throw"===n.type){var o=n.arg;P(r)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(e,t,r){return this.delegate={iterator:L(e),resultName:t,nextLoc:r},"next"===this.method&&(this.arg=void 0),h}},e}},2:(e,t,r)=>{function n(e){return n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},n(e)}r.d(t,{Z:()=>n})}},r={};function n(e){var o=r[e];if(void 0!==o)return o.exports;var i=r[e]={exports:{}};return t[e](i,i.exports,n),i.exports}n.m=t,n.n=e=>{var t=e&&e.__esModule?()=>e.default:()=>e;return n.d(t,{a:t}),t},n.d=(e,t)=>{for(var r in t)n.o(t,r)&&!n.o(e,r)&&Object.defineProperty(e,r,{enumerable:!0,get:t[r]})},n.f={},n.e=e=>Promise.all(Object.keys(n.f).reduce(((t,r)=>(n.f[r](e,t),t)),[])),n.u=e=>"js/"+e+".chunk.js",n.o=(e,t)=>Object.prototype.hasOwnProperty.call(e,t),n.r=e=>{"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},e={179:1},n.f.require=(t,r)=>{e[t]||(t=>{var r=t.modules,o=t.ids,i=t.runtime;for(var a in r)n.o(r,a)&&(n.m[a]=r[a]);i&&i(n);for(var u=0;u<o.length;u++)e[o[u]]=1})(require("./"+n.u(t)))},(()=>{var e=n(165),t=n(861);n(689);const r=require("react-dom/server");var o=n.n(r);const i=require("express");var a=n.n(i);const u=require("react-router-dom/server");var c=n(661),s=n(997);const l=function(){return(0,s.jsxs)("ul",{children:[(0,s.jsx)("li",{children:(0,s.jsx)(c.Link,{to:"/red",children:"Red"})}),(0,s.jsx)("li",{children:(0,s.jsx)(c.Link,{to:"/blue",children:"Blue"})}),(0,s.jsx)("li",{children:(0,s.jsx)(c.Link,{to:"/users",children:"Users"})})]})},f=require("@loadable/component");var p=n.n(f),h=p()((function(){return n.e(952).then(n.bind(n,952))})),d=p()((function(){return n.e(175).then(n.bind(n,175))})),v=p()((function(){return n.e(499).then(n.bind(n,499))}));const y=function(){return(0,s.jsxs)("div",{children:[(0,s.jsx)(l,{}),(0,s.jsx)("hr",{}),(0,s.jsxs)(c.Routes,{children:[(0,s.jsx)(c.Route,{path:"/red",element:(0,s.jsx)(h,{})}),(0,s.jsx)(c.Route,{path:"/blue",element:(0,s.jsx)(d,{})}),(0,s.jsx)(c.Route,{path:"/users",element:(0,s.jsx)(v,{})})]})]})},m=require("path");var g=n.n(m);const x=require("fs");var b=n.n(x);const w=require("redux");var j=n(22);const E=require("redux-thunk");var S=n.n(E);const O=require("redux-saga");var P=n.n(O),_=n(821),L=n(477),k=(0,e.Z)().mark(Z);function Z(){return(0,e.Z)().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,(0,L.all)([(0,_.HD)()]);case 2:case"end":return e.stop()}}),k)}const R=(0,w.combineReducers)({users:_.ZP});var T=n(701),q=JSON.parse(b().readFileSync(g().resolve("./build/asset-manifest.json"),"utf8")),G=Object.keys(q.files).filter((function(e){return/chunk\.js$/.exec(e)})).map((function(e){return'<script src="'.concat(q.files[e],'"><\/script>')})).join("");function N(e,t){return'<!DOCTYPE html>\n        <html lang="en">\n        <head>\n            <meta charset="utf-8" />\n            <link rel="shortcut icon" href="/favicon.ico" />\n            <meta\n                name="viewport"\n                content="width=device-width,initial-scale=1,shrink-to-fit=no"\n            />\n            <meta name="theme-color" content="#000000" />\n            <title>React App</title>\n            <link href="'.concat(q.files["main.css"],'" rel="stylesheet" />\n        </head>\n        <body>\n            <noscript>You need to enable JavaScript to run this app.</noscript>\n            <div id="root">\n                ').concat(e,"\n            </div>     \n            ").concat(t,"       \n            ").concat(G,'\n            <script src="').concat(q.files["main.js"],'"><\/script>\n        </body>\n        </html>        \n        ')}var D=a()(),U=function(){var r=(0,t.Z)((0,e.Z)().mark((function t(r,n,i){var a,c,l,f,p,h,d,v,m;return(0,e.Z)().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return a={},c=P()(),l=(0,w.createStore)(R,(0,w.applyMiddleware)(S(),c)),f=c.run(Z).toPromise,p={done:!1,promises:[]},h=(0,s.jsx)(T.ZP.Provider,{value:p,children:(0,s.jsx)(j.Provider,{store:l,children:(0,s.jsx)(u.StaticRouter,{location:r.url,context:a,children:(0,s.jsx)(y,{})})})}),o().renderToStaticMarkup(h),l.dispatch(O.END),e.prev=8,e.next=11,f;case 11:return e.next=13,Promise.all(p.promises);case 13:e.next=18;break;case 15:return e.prev=15,e.t0=e.catch(8),e.abrupt("return",n.status(500));case 18:p.done=!0,d=o().renderToString(h),v=JSON.stringify(l.getState()).replace(/</g,"\\u003c"),m="<script>__PRELOADED_STATE__ = ".concat(v,"<\/script>"),n.send(N(d,m));case 23:case"end":return e.stop()}}),t,null,[[8,15]])})));return function(e,t,n){return r.apply(this,arguments)}}(),C=a().static(g().resolve("./build"),{index:!1});D.use(C),D.use(U),D.listen(5e3,(function(){console.log("Running on http://localhost:5000")}))})()})();