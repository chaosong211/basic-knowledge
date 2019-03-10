Java中的基本数据类型是特殊变量，因为不是通过new 创建的，而是创建一个并非是引用的“自动”变量，所谓自动是指变量直接存储“值”，并且是存储在堆栈中，因此会高效得多。
以下列出了八个基本数据类型，大小及其对应的包装类

基本类型	大小(字节bit)	最小值	最大值	包装器类型
boolean	无定义	-	-	Boolean
char	16	Unicode 0	Unicode 2^16 -1	Character
byte	8	-128	+127	Byte
short	16	-2^15	2^15 -1	Short
int	32	-2^31	 2^31 -1	Integer
long	64	-2^63	2^63 -1	Long
float	32	IEEE754	IEEE754	Float
double	64	IEEE754	IEEE754	Double

