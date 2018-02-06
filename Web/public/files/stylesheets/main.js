import React, {StyleSheet, Dimensions, PixelRatio} from "react-native";
const {width, height, scale} = Dimensions.get("window"),
    vw = width / 100,
    vh = height / 100,
    vmin = Math.min(vw, vh),
    vmax = Math.max(vw, vh);

export default StyleSheet.create({
    "*": {
        "marginTop": 0,
        "marginRight": 0,
        "marginBottom": 0,
        "marginLeft": 0,
        "paddingTop": 0,
        "paddingRight": 0,
        "paddingBottom": 0,
        "paddingLeft": 0,
        "WebkitBoxSizing": "border-box",
        "boxSizing": "border-box"
    },
    "body": {
        "backgroundColor": "#f3f3f3",
        "color": "#333"
    },
    "page": {
        "paddingTop": 20,
        "paddingRight": 0,
        "paddingBottom": 20,
        "paddingLeft": 0
    },
    "btn-primary": {
        "backgroundColor": "#3ba7dc",
        "borderColor": "#3095c6"
    },
    "btn-primary:hover": {
        "backgroundColor": "#3095c6",
        "borderColor": "#3095c6"
    },
    "col-xl-1": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-1": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-1": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-2": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-2": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-md-2": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-2": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-3": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-3": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-md-3": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-3": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-4": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-4": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-md-4": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-4": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-5": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-5": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-md-5": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-5": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-6": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-6": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-md-6": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-6": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-7": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-7": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-md-7": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-7": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-8": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-8": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-md-8": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-8": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-9": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-9": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-md-9": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-9": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-10": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-100": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-10": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-11": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-111": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-11": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xl-12": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxl-122": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "col-xxxl-12": {
        "position": "relative",
        "minHeight": 1,
        "paddingRight": 15,
        "paddingLeft": 15
    },
    "visible-xl": {
        "display": "none !important"
    },
    "visible-xxl": {
        "display": "none !important"
    },
    "visible-xxxl": {
        "display": "none !important"
    },
    "navbar-default": {
        "border": "none",
        "backgroundColor": "#293c55",
        "zIndex": 10000,
        "WebkitTransition": "background-color 0.5s linear",
        "transition": "background-color 0.5s linear",
        "height": 50
    },
    "navbar-default navbar-nav": {
        "WebkitTransition": "background-color 0.5s linear",
        "transition": "background-color 0.5s linear"
    },
    "navbar-default navbar-nav li": {
        "position": "relative"
    },
    "navbar-default navbar-nav li a": {
        "color": "rgba(255,255,255,0.45)",
        "backgroundColor": "none !important",
        "paddingTop": 15,
        "paddingRight": 20,
        "paddingBottom": 15,
        "paddingLeft": 20,
        "WebkitTransition": "0.5s background-color",
        "transition": "0.5s background-color",
        "fontSize": 14
    },
    "navbar-default navbar-nav li a:before": {
        "content": "''",
        "position": "absolute",
        "left": "50%",
        "right": "50%",
        "top": 0,
        "background": "#3ba7dc",
        "height": 4,
        "WebkitTransitionProperty": "'left, right'",
        "transitionProperty": "'left, right'",
        "WebkitTransitionDuration": ".3s",
        "transitionDuration": ".3s",
        "WebkitTransitionTimingFunction": "ease-out",
        "transitionTimingFunction": "ease-out"
    },
    "navbar-default navbar-nav li a:hover": {
        "color": "#fff",
        "backgroundColor": "#162436"
    },
    "navbar-default navbar-nav li a:focus": {
        "color": "#fff",
        "backgroundColor": "#162436"
    },
    "navbar-default navbar-nav li a:hover:before": {
        "left": 0,
        "right": 0
    },
    "navbar-default navbar-nav li a:focus:before": {
        "left": 0,
        "right": 0
    },
    "navbar-default navbar-nav li a iconfont": {
        "fontSize": 12
    },
    "navbar-default navbar-nav liopen": {
        "backgroundColor": "#162436",
        "color": "#fff"
    },
    "navbar-default navbar-nav liopen>a:focus": {
        "color": "#eee",
        "backgroundColor": "#162436"
    },
    "navbar-default navbar-nav liopen>a:hover": {
        "color": "#eee",
        "backgroundColor": "#162436"
    },
    "navbar-default navbar-nav liactive>a": {
        "paddingTop": 11,
        "borderTop": "4px solid #3ba7dc",
        "color": "#fff",
        "backgroundColor": "#0e151f",
        "WebkitTransition": "0.5s background-color",
        "transition": "0.5s background-color"
    },
    "navbar-default navbar-nav liactive>a:before": {
        "display": "none"
    },
    "navbar-default navbar-nav liactive>a:hover": {
        "color": "#fff",
        "backgroundColor": "#162436"
    },
    "navbar-default navbar-nav liactive>a:focus": {
        "color": "#fff",
        "backgroundColor": "#162436"
    },
    "navbar-default navbar-nav li dropdown-menu": {
        "width": "100%",
        "paddingTop": 0,
        "paddingRight": 0,
        "paddingBottom": 0,
        "paddingLeft": 0,
        "backgroundColor": "#162436",
        "WebkitBoxShadow": "none",
        "boxShadow": "none",
        "border": "none"
    },
    "navbar-default navbar-nav li dropdown-menu li": {
        "backgroundColor": "#162436",
        "borderTop": "none",
        "paddingTop": 5,
        "paddingRight": 0,
        "paddingBottom": 5,
        "paddingLeft": 0
    },
    "navbar-default navbar-nav li dropdown-menu li a": {
        "paddingTop": 8,
        "paddingRight": 20,
        "paddingBottom": 8,
        "paddingLeft": 20
    },
    "navbar-default navbar-nav li dropdown-menu li:hover": {
        "backgroundColor": "#3ba7dc"
    },
    "navbar-default navbar-nav li dropdown-menu li:focus": {
        "backgroundColor": "#3ba7dc"
    },
    "navbar-default navbar-nav li dropdown-menu li:hover a": {
        "backgroundColor": "#3ba7dc"
    },
    "navbar-default navbar-nav li dropdown-menu li:focus a": {
        "backgroundColor": "#3ba7dc"
    },
    "navbar-default navbar-nav li ul a:before": {
        "display": "none"
    },
    "navbar-default navbar-logo": {
        "height": 32,
        "marginTop": -6,
        "marginLeft": -2
    },
    "navbar-default navbar-collapse": {
        "borderTop": "none"
    },
    "navbar-default navbar-toggle": {
        "paddingTop": 1,
        "paddingRight": 5,
        "paddingBottom": 1,
        "paddingLeft": 5,
        "marginTop": 7,
        "marginRight": 16,
        "marginBottom": 0,
        "marginLeft": 0,
        "borderColor": "#384E6B",
        "backgroundColor": "#384E6B"
    },
    "navbar-default navbar-toggle icon-bar": {
        "marginTop": 7,
        "marginRight": 0,
        "marginBottom": "!important",
        "marginLeft": 0,
        "height": 1,
        "backgroundColor": "#fff"
    },
    "navbar-default navbar-toggle:hover": {
        "borderColor": "#384E6B",
        "backgroundColor": "#384E6B"
    },
    "navbar-default navbar-toggle:focus": {
        "borderColor": "#384E6B",
        "backgroundColor": "#384E6B"
    },
    "menu-btn": {
        "display": "none",
        "float": "right",
        "height": 45,
        "lineHeight": 45,
        "marginTop": 5,
        "marginRight": 20,
        "marginBottom": 0,
        "marginLeft": 0,
        "fontSize": 30,
        "color": "#fff",
        "cursor": "pointer"
    },
    "navbar-bg": {
        "backgroundColor": "rgba(41,60,85,0.4)"
    },
    "navbar-bg navbar-nav li a": {
        "color": "#fff"
    },
    "navbar-bg navbar-nav liactive a": {
        "color": "#fff",
        "backgroundColor": "transparent"
    },
    "navbar-bg navbar-nav nav-github": {
        "opacity": 1
    },
    "nav-github": {
        "opacity": 0.4,
        "WebkitTransition": "0.5s",
        "transition": "0.5s"
    },
    "nav-github img": {
        "position": "relative",
        "top": -1
    },
    "nav-github:hover": {
        "opacity": 1
    },
    "nav-dropdown-panel": {
        "display": "none",
        "position": "absolute",
        "right": 0,
        "zIndex": 99999
    },
    "nav-dropdown-panellogin-dropdown-panel": {
        "width": 350
    },
    "nav-dropdown-panellogin-dropdown-panel form": {
        "paddingTop": 20,
        "paddingRight": 30,
        "paddingBottom": 0,
        "paddingLeft": 30
    },
    "nav-dropdown-paneluser-dropdown-panel": {
        "width": 150
    },
    "nav-dropdown-paneluser-dropdown-panel panel-body": {
        "paddingTop": 0,
        "paddingRight": 0,
        "paddingBottom": 0,
        "paddingLeft": 0
    },
    "main-container": {
        "position": "absolute",
        "left": 0,
        "right": 0,
        "bottom": 0,
        "top": 51
    },
    "main-container handler": {
        "position": "absolute",
        "left": "50%",
        "top": 0,
        "bottom": 0,
        "width": 5,
        "cursor": "col-resize",
        "zIndex": 100,
        "backgroundColor": "transparent",
        "borderLeft": "1px solid #ccc"
    },
    "main-containerno-top": {
        "top": 0
    },
    "code-container": {
        "position": "absolute",
        "left": 0,
        "bottom": 0,
        "top": 0,
        "width": "50%"
    },
    "control-panel": {
        "height": 30,
        "position": "absolute",
        "left": 0,
        "right": 0,
        "top": 0,
        "zIndex": 20,
        "paddingTop": 0,
        "paddingRight": 0,
        "paddingBottom": 0,
        "paddingLeft": 0,
        "WebkitBoxShadow": "0 2px 10px rgba(0,0,0,0.2)",
        "boxShadow": "0 2px 10px rgba(0,0,0,0.2)"
    },
    "control-panel setting-panel": {
        "display": "inline-block"
    },
    "control-panel setting-panel btn-group+btn-group": {
        "marginLeft": 10
    },
    "control-panel control-btn-panel": {
        "float": "right"
    },
    "control-panel control-btn-panel btn": {
        "color": "#FFF",
        "WebkitBorderRadius": 0,
        "borderRadius": 0,
        "backgroundColor": "#3FA7DC",
        "marginLeft": 10,
        "border": "none",
        "height": 30,
        "width": 50
    },
    "control-panel control-btn-panel btn:hover": {
        "backgroundColor": "#277EAB"
    },
    "code-panel": {
        "position": "absolute",
        "top": 30,
        "bottom": 0,
        "left": 0,
        "right": 0,
        "paddingTop": 10,
        "paddingRight": 10,
        "paddingBottom": 10,
        "paddingLeft": 10
    },
    "code-panel ::-webkit-scrollbar": {
        "height": 8,
        "width": 8,
        "WebkitTransition": "all 0.3s ease-in-out",
        "transition": "all 0.3s ease-in-out",
        "WebkitBorderRadius": 2,
        "borderRadius": 2
    },
    "code-panel ::-webkit-scrollbar-button": {
        "display": "none"
    },
    "code-panel ::-webkit-scrollbar-thumb": {
        "width": 8,
        "minHeight": 15,
        "background": "rgba(50,50,50,0.6) !important",
        "WebkitTransition": "all 0.3s ease-in-out",
        "transition": "all 0.3s ease-in-out",
        "WebkitBorderRadius": 2,
        "borderRadius": 2
    },
    "code-panel ::-webkit-scrollbar-thumb:hover": {
        "background": "rgba(0,0,0,0.5) !important"
    },
    "code-info": {
        "position": "absolute",
        "bottom": 0,
        "overflow": "hidden",
        "height": 30,
        "lineHeight": 30,
        "paddingTop": 0,
        "paddingRight": 10,
        "paddingBottom": 0,
        "paddingLeft": 10,
        "fontSize": 0.9
    },
    "code-info code-info-time": {
        "color": "#333",
        "display": "inline-block",
        "marginRight": 10
    },
    "code-info code-info-type-info": {
        "color": "#333"
    },
    "code-info code-info-type-warn": {
        "color": "#f93"
    },
    "code-info code-info-type-error": {
        "color": "#e43c59"
    },
    "left-chart-nav": {
        "position": "fixed",
        "top": 0,
        "bottom": 0,
        "left": 0,
        "paddingTop": 51,
        "width": 155,
        "backgroundColor": "#293c55",
        "overflowY": "hidden"
    },
    "left-chart-nav:hover": {
        "overflowY": "auto"
    },
    "left-chart-nav li": {
        "height": 54,
        "paddingTop": 10,
        "paddingRight": 0,
        "paddingBottom": 10,
        "paddingLeft": 20,
        "WebkitTransition": "0.5s",
        "transition": "0.5s"
    },
    "left-chart-nav li a": {
        "color": "#ccc",
        "position": "relative",
        "display": "block",
        "WebkitTransition": "0.5s",
        "transition": "0.5s"
    },
    "left-chart-nav li a chart-name": {
        "display": "inline-block",
        "position": "relative",
        "top": -12,
        "marginLeft": 10
    },
    "left-chart-nav li a chart-icon": {
        "content": "''",
        "display": "inline-block",
        "width": 32,
        "height": 32,
        "backgroundImage": "url(\"../images/chart-icon.png\")",
        "backgroundSize": 32,
        "backgroundRepeat": "no-repeat",
        "WebkitBorderRadius": "50%",
        "borderRadius": "50%",
        "border": "1px solid #999"
    },
    "left-chart-nav liactive": {
        "backgroundColor": "#e43c59"
    },
    "left-chart-nav liactive a": {
        "color": "#f3f3f3"
    },
    "left-chart-nav liactive chart-icon": {
        "borderColor": "#f3f3f3"
    },
    "left-chart-nav li:hover": {
        "backgroundColor": "#162436"
    },
    "left-chart-nav-line chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -1
    },
    "left-chart-nav-bar chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -33
    },
    "left-chart-nav-scatter chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -65
    },
    "left-chart-nav-pie chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -129
    },
    "left-chart-nav-radar chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -161
    },
    "left-chart-nav-funnel chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -321
    },
    "left-chart-nav-gauge chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -289
    },
    "left-chart-nav-map chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -257
    },
    "left-chart-nav-graph chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -225
    },
    "left-chart-nav-treemap chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -481
    },
    "left-chart-nav-parallel chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -513
    },
    "left-chart-nav-sankey chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -545
    },
    "left-chart-nav-candlestick chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -97
    },
    "left-chart-nav-boxplot chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -577
    },
    "left-chart-nav-heatmap chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -353
    },
    "left-chart-nav-pictorialBar chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -769
    },
    "left-chart-nav-themeRiver chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -801
    },
    "left-chart-nav-calendar chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -833
    },
    "left-chart-nav-custom chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -865
    },
    "left-chart-nav-sunburst chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -897
    },
    "left-chart-nav-tree chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -449
    },
    "left-chart-nav-globe chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-bar3D chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-scatter3D chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-surface chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-map3D chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-lines3D chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-line3D chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-scatterGL chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-linesGL chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-flowGL chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-graphGL chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "left-chart-nav-geo3D chart-icon": {
        "backgroundPositionX": -1,
        "backgroundPositionY": -929
    },
    "toolbar": {
        "height": 30,
        "position": "fixed",
        "marginTop": 20,
        "width": 500,
        "right": 0,
        "zIndex": 200
    },
    "theme": {
        "float": "right",
        "marginRight": 30
    },
    "theme>span": {
        "verticalAlign": "middle",
        "display": "inline-block",
        "marginRight": 10,
        "fontSize": 16,
        "fontWeight": "bold"
    },
    "theme a": {
        "cursor": "pointer",
        "display": "inline-block",
        "verticalAlign": "middle",
        "width": 30,
        "height": 30,
        "marginTop": 0,
        "marginRight": 5,
        "marginBottom": 0,
        "marginLeft": 5,
        "WebkitBorderRadius": 2,
        "borderRadius": 2,
        "WebkitBoxSizing": "content-box",
        "boxSizing": "content-box",
        "background": "#fff"
    },
    "theme a span": {
        "display": "inline-block",
        "width": 26,
        "height": 26,
        "marginLeft": 2,
        "marginTop": 2
    },
    "theme a:hover": {
        "WebkitBoxShadow": "0px 0px 8px rgba(0,0,0,0.1)",
        "boxShadow": "0px 0px 8px rgba(0,0,0,0.1)"
    },
    "theme aselected": {
        "border": "1px solid #e43c59"
    },
    "theme adefault span": {
        "background": "linear-gradient(135deg, #de7e7b 0%, #c23531 50%, #2f4554 51%, #547b95 100%)"
    },
    "theme alight span": {
        "background": "linear-gradient(135deg, #8dcaea 0%, #37A2DA 50%, #ffd85c 51%, #fff0c2 100%)"
    },
    "theme adark": {
        "background": "#333"
    },
    "theme adark span": {
        "background": "linear-gradient(135deg, #f0bcb9 0%, #dd6b66 50%, #759aa0 51%, #b1c6ca 100%)"
    },
    "toolbar theme": {
        "paddingTop": 4,
        "paddingRight": 10,
        "paddingBottom": 4,
        "paddingLeft": 10,
        "background": "#fff",
        "WebkitBorderRadius": 5,
        "borderRadius": 5,
        "WebkitBoxShadow": "0 0 15px rgba(0,0,0,0.1)",
        "boxShadow": "0 0 15px rgba(0,0,0,0.1)",
        "border": "1px solid #aaa"
    },
    "toolbar themedark": {
        "background": "#222",
        "color": "#fff"
    },
    "popover-title": {
        "color": "#000"
    },
    "theme-palette": {
        "color": "#000",
        "fontSize": 18
    },
    "theme-palette span": {
        "width": 20,
        "height": 20,
        "marginLeft": 3,
        "display": "inline-block"
    },
    "chart-list-panel": {
        "marginTop": 30,
        "marginRight": 15,
        "marginBottom": 30,
        "marginLeft": 15
    },
    "chart-list-panel h3": {
        "marginBottom": 20
    },
    "chart-list-panel chart": {
        "width": "100%",
        "maxWidth": 350,
        "marginTop": 0,
        "marginRight": "auto",
        "marginBottom": 30,
        "marginLeft": "auto",
        "WebkitBorderRadius": 2,
        "borderRadius": 2,
        "backgroundColor": "#fff",
        "WebkitBoxShadow": "0 1px 2px rgba(0,0,0,0.1)",
        "boxShadow": "0 1px 2px rgba(0,0,0,0.1)"
    },
    "chart-list-panel chart chart-link": {
        "position": "relative",
        "display": "block"
    },
    "chart-list-panel chart chart-link chart-area": {
        "width": "100%",
        "height": "100%",
        "paddingTop": 8,
        "paddingRight": 8,
        "paddingBottom": 8,
        "paddingLeft": 8
    },
    "chart-list-panel chart chart-link chart-title": {
        "color": "#293c55",
        "overflow": "hidden",
        "textOverflow": "ellipsis",
        "whiteSpace": "nowrap",
        "paddingTop": 10,
        "paddingRight": 10,
        "paddingBottom": 2,
        "paddingLeft": 10,
        "marginTop": 0,
        "marginRight": 0,
        "marginBottom": 0,
        "marginLeft": 0,
        "fontWeight": "normal",
        "fontSize": 16
    },
    "chart-list-panel chart chart-info": {
        "paddingTop": 5,
        "paddingRight": 0,
        "paddingBottom": 5,
        "paddingLeft": 0,
        "fontWeight": "bold"
    },
    "chart-list-panel chart chart-info chart-icon": {
        "float": "right"
    },
    "chart-list-panel chart chart-info chart-icon chart-delete": {
        "display": "none",
        "WebkitTransition": "1s",
        "transition": "1s"
    },
    "chart-list-panel chart:hover chart-info chart-icon chart-delete": {
        "display": "block",
        "textDecoration": "none"
    },
    "dgmain *": {
        "WebkitBoxSizing": "content-box",
        "boxSizing": "content-box"
    },
    "dgmain input": {
        "lineHeight": "normal"
    },
    "dgmaina": {
        "overflowX": "visible"
    },
    "right-container": {
        "position": "absolute",
        "right": 0,
        "width": "50%",
        "height": "100%",
        "paddingTop": 0,
        "paddingRight": 0,
        "paddingBottom": 0,
        "paddingLeft": 5,
        "border": "none",
        "zIndex": 30,
        "background": "#f3f3f3"
    },
    "right-container right-panel": {
        "paddingTop": 10,
        "paddingRight": 10,
        "paddingBottom": 10,
        "paddingLeft": 15
    },
    "fork-btn": {
        "display": "none"
    },
    "reset-btn": {
        "display": "none"
    },
    "chart-panel": {
        "position": "absolute",
        "top": 0,
        "right": 0,
        "bottom": 50,
        "left": 0,
        "paddingTop": 10,
        "paddingRight": 10,
        "paddingBottom": 10,
        "paddingLeft": 10,
        "WebkitBoxSizing": "border-box",
        "boxSizing": "border-box"
    },
    "tool-panel": {
        "position": "absolute",
        "bottom": 0,
        "left": 0,
        "right": 0
    },
    "tool-panel theme": {
        "marginBottom": 10,
        "float": "right"
    },
    "tool-panel theme a": {
        "cursor": "pointer"
    },
    "tool-panel download": {
        "float": "right",
        "marginRight": 10
    },
    "dgmain c select": {
        "color": "#000"
    },
    "icon-bar": {
        "display": "inline-block",
        "marginTop": 0,
        "marginRight": 0.4,
        "marginBottom": 0,
        "marginLeft": 0.4,
        "color": "#ccc"
    },
    "icon-bar span::before": {
        "position": "relative",
        "top": 0.2,
        "marginRight": 0.25,
        "color": "#ccc"
    },
    "icon-bar:hover": {
        "color": "#999"
    },
    "icon-bar:hover span::before": {
        "color": "#999"
    },
    "profile user-info": {
        "textAlign": "center"
    },
    "profile user-info user-info-avatar": {
        "width": 100,
        "height": 100,
        "WebkitBorderRadius": 50,
        "borderRadius": 50
    },
    "profile user-info user-info-name": {
        "marginTop": 0.5,
        "marginRight": 0,
        "marginBottom": 0.25,
        "marginLeft": 0,
        "fontSize": 2,
        "fontWeight": "bold"
    },
    "profile user-info user-info-data": {
        "fontSize": 1.5
    },
    "profile user-info user-info-data ul": {
        "listStyleType": "none"
    },
    "view-main": {
        "position": "absolute",
        "left": 0,
        "right": 0,
        "top": 0,
        "bottom": 0
    },
    "view-main control-panel": {
        "position": "absolute",
        "bottom": 0,
        "height": 30,
        "paddingRight": 10,
        "width": "100%",
        "background": "#F3F3F3",
        "WebkitBoxShadow": "0 0 10px rgba(0,0,0,0.2)",
        "boxShadow": "0 0 10px rgba(0,0,0,0.2)",
        "zIndex": 1001
    },
    "view-main control-panel btn": {
        "float": "right",
        "marginTop": 3,
        "marginRight": 5,
        "marginBottom": 3,
        "marginLeft": 5,
        "paddingTop": 3,
        "paddingRight": 5,
        "paddingBottom": 3,
        "paddingLeft": 5,
        "background": "#337ab7",
        "border": "none",
        "color": "white"
    },
    "view-main chart": {
        "position": "absolute",
        "left": 0,
        "right": 0,
        "top": 0,
        "bottom": 30,
        "paddingTop": 2,
        "paddingRight": 2,
        "paddingBottom": 2,
        "paddingLeft": 2
    },
    "view-mask": {
        "position": "absolute",
        "left": 0,
        "top": 0,
        "right": 0,
        "bottom": 0,
        "zIndex": 1000
    },
    "explore-container": {
        "marginLeft": 155,
        "paddingTop": 51,
        "paddingRight": 20,
        "paddingBottom": 51,
        "paddingLeft": 20
    }
});