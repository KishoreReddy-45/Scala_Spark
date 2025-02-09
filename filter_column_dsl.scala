			println
			println("=====NOT  single column filter  category= Gymnastics")
			println

			val scol  =  df.filter( "   category  != 'Gymnastics'    " )

			scol.show() 






			println
			println("=====NOT Multi column filter  category= Gymnastics and spendby=cash")
			println			



			val mulcol = df.filter(  "    category!='Gymnastics'  and spendby !='cash'                 "  )


			mulcol.show()




			println
			println("=====NOT Multi column filter  category= Gymnastics or spendby=cash")
			println					


			val mulcolor = df.filter(  "      category !='Gymnastics'  or spendby !='cash'                "  )

			mulcolor.show()



			println
			println("=====NOT Multi value  category= Gymnastics or category=Exercise")
			println					


			val infilter=  df.filter("  category not in ('Gymnastics','Exercise')           ")


			infilter.show()





			println
			println("=====NOT product contains Gymnastics====")
			println					


			val likefilter = df.filter("   product not like   '%Gymnastics%'    ")

			likefilter.show()



			println
			println("===== product is null====")
			println				


			val nullfilter = df.filter("     product is null  ")

			nullfilter.show()




			println
			println("===== product is not null====")
			println				


			val notnullfilter = df.filter("     product is not null  ")

			notnullfilter.show()








