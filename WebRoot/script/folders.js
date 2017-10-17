var OutlookBar={
"format":
   {"heightpanel":25, "imagewidth":50, "imageheight":50, "arrowheight":17,"heightcell":100,"coloroutlook":"#DBEAF5","arrange_text":"bottom", "rollback":false, "img_arrows_up":"images/pic/arup2.gif","img_arrows_dn":"images/pic/ardn2.gif"},
"panels":
[
   {"text":"系统管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"重新登陆","textCSS":"a1","image":'images/pic/2.gif',    "url":'temp.jsp', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"退出系统","textCSS":"a1", "image":'images/pic/3.gif',    "url":'servlet/Login_out', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
          
      ]
   },
    {"text":"采购管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"供应商管理","textCSS":"a1", "image":'images/pic/1.gif',    "url":'servlet/Cur', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"添加采购单","textCSS":"a1","image":'images/pic/2.gif',    "url":'servlet/Ser', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"采购单了结","textCSS":"a1", "image":'images/pic/3.gif',    "url":'servlet/Fin', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"采购单查询","textCSS":"a1", "image":'images/pic/4.gif',    "url":'cha', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          
      ]
   },
   {"text":"仓储管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"产品分类管理","textCSS":"a1", "image":'images/pic/11.gif',    "url":'servlet/Category', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"入库登记","textCSS":"a1", "image":'images/pic/8.gif',    "url":'inregister', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"出库登记","textCSS":"a1", "image":'images/pic/9.gif',    "url":'outregist', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
		  {"text":"库存盘点","textCSS":"a1", "image":'images/pic/9.gif',    "url":'store?page=1', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"库存查询","textCSS":"a1", "image":'images/pic/10.gif',    "url":'pro?page=1', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
      ]
   },
   {"text":"销售管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"客户管理","textCSS":"a1", "image":'images/pic/13.gif',    "url":'pageSplit', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
		  ,
		   {"text":"新添销售单","textCSS":"a1", "image":'images/pic/13.gif',    "url":'somainGet', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
		   ,
		    {"text":"销售单了结","textCSS":"a1", "image":'images/pic/13.gif',    "url":'somainFinishGet', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
		,
			  {"text":"销售单查询","textCSS":"a1", "image":'images/pic/13.gif',    "url":'saleSelect', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
         
      ]
   }
   ,
    {"text":"业务报表", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"月度采购报表","textCSS":"a1", "image":'images/pic/11.gif',    "url":'baobiao', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"月度入库报表","textCSS":"a1", "image":'images/pic/13.gif',    "url":'ruku', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
		  ,
		   {"text":"月度出库报表","textCSS":"a1", "image":'images/pic/13.gif',    "url":'chuku', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
		   ,
		    {"text":"产品库存报表","textCSS":"a1", "image":'images/pic/13.gif',    "url":'kucun', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
		,
			  {"text":"月度销售报表","textCSS":"a1", "image":'images/pic/13.gif',    "url":'saleJournaling', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
         
      ]
   }
  
]
}
