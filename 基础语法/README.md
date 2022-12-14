# 基础语法
本章将介绍java的一些基础语法与基础知识，包括有java的基本数据结构，面向对象编程的基本思路

## 第一章节: 基本数据类型以及变量介绍(Chapter1)
### 1、数据类型和运算符的介绍
- java常见的数据类型包括整数类型、浮点数、单字符、bool类型、字符串类型(不属于基本数据类型)
- 整数:
    - 二进制0b开头, 八进制0开头, 十六进制0x开头
    - 包含有byte、short、int、long四种类型，每种类型的位宽长度从低到高为8到64
    - 注意在long类型定义时需要在末尾加上l
    - 整数常量默认是int类型, 所以short = short + 1会报错, 因为1是int的(但使用short += 1则不会报错)
        - byte n = 10不会报错是因为: 将具体数值给byte时会先判断该数是否在byte的范围内，如果在则可以赋值。如果是按变量之间相互赋值则会直接判断类型
- 浮点数:
    - 包含有float、double两种类型，其中从低到高是32、64位宽
    - float定义时需要在数字末尾加上f，因为默认的小数是double类型
- 单字符(16位宽)采用单引号''，字符串采用双引号""
- 注意：
    - 低位与高位运算会自动往高位转换，但低位与低位运算会出现内存溢出
    - 从高位要转化为低位类型，我们需要使用**强制类型转换**: 低位数据类型 a = (高位数据类型) b
    - 注意浮点数计算后的陷进，浮点数计算后是一个估计值不能直接使用==进行相等比较(直接定义是可以的)
    - 在不同数据类型的混合运算中，会计算出最大的数据类型，将所有的数据转换为最大的。
    - byte/short不能自动转换为char，所以不能将byte/short变量赋值给char变量。
    - byte、short、char可以进行运算，在运算(单种运算/混合运算)时会将所有数值变为int

### 2、变量定义介绍
- 变量定义: 数据类型 变量名 [= value]; 可以在定义时同时赋值，也可以不赋值，如果不赋值则系统自动赋值null(数字类型默认赋值0)
- 常量定义: final 数据类型 常量名 [= value];

### 3、基本数据类型与String类对象的转化
- 基本数据类型转换为String类型可以使用+""的方式即可，如果+两边出现string类型，则+改变为连接字符串的符号，否则视为数字加法。如果有多个+则从左往右运算, 直到知碰到string类型变为字符串连接符
- String类型转化为基本数据类型需要调用基本数据类型对应的.parsexxx(String)方法
    - Integer.parseInt(String)
    - Double.parseDouble(String)int
    - Float.parseFloat(String)
    - Long.parseLong(String)
    - Byte.parseByte(String)
    - Boolean.parseBoolean(String)
    - Short.parseShort(String)
    - 字符串转为char的操作是将字符串中的某个字符取出来，String.charAt(index)
- 注意：
    - 将String转化为基本数据类型时需要保证转化后的有效数据，"hollow"不能转化为int

## 第二章节: 运算符介绍以及二进制计算细节(Chapter2)
### 4、运算符
- 算数运算符号: +、-、*、/、%(取余)、++(自增)、--(自减)
    - a%b(取余)的本质是: a - ( (int)a / b * b);
    - ++/--表示自增/自减，独立使用时a++(++a)本质是a = a + 1; 非独立使用时，++a表示a先+1再参与其他运算, a++表示a先参与其他运算再+1；需要注意到的是自增在参与运算时底层其实是利用了临时变量的，++a的执行顺序是(1)a = a + 1 (2)temp = a (3)temp参与其他运算；a++的执行顺序是(1)temp = a (2)a = a + 1 (3)temp参与其他运算
- 关系运算符号: <、>、>=、<=
- 逻辑运算符: 短路或:||  短路与:&&  非:!  逻辑或:|  逻辑与:&  异或:^(不同为真,相同为假)
    - 短路或/短路与 表示如果第一个表达式的结果已经能得到逻辑结果，那么将不会执行第二个表达式
- 逻辑运算符: 逻辑或:|  逻辑与:&  异或:^(不同为真,相同为假)
    - 上述运算符可以对二进制数值进行操作
- 赋值运算符号: +=, -=, *=, /=
    - 赋值运算符号隐藏了强制类型转换，比如byte b=1, b+=1, 得到的结果b=2且b仍为byte类型
- 三元运算符: x ? y : z  表示如果x=true则结果为y, 否则结果为z
    - 三元运算符如果需要将返回值进行赋值，需要保证返回值和接受变量类型匹配
    
### 5、键盘输入语句
- Scanner类属于java.util这个包，可以通过import java.util.Scanner导入该类。
- 创建new Scanner(System.in,"UTF-8")对象，其中"UTF-8"表示将System.in的获取到的字节，根据UTF-8字符集转化为字符。(此处需要保证输入字符编码模式需要对应上UTF-8)

### 6、进制
- 二进制: 0B/0b开头，例如：0b1010
- 八进制: 0开头，例如：0172
- 十六进制：0x开头，例如：0x10ac
- 其他进制转十进制：从最低位开始，将每个位上的数提取出来，乘以2/8/16的(位数-1)次方，然后求和。
- 十进制转其他进制：将十进制的数不断除以2/8/16，直到商为0，将每一步的余数倒过来书写即可。
- 二进制转八、十六进制: 从低位开始每3/4位一组，转化十进制数，这些数就是为8/16进制数了。
- 八、十六进制转二进制: 将每一位数转为对应的3/4位的二进制数即可。
- 位运算：<<(向左位移)、>>(向右位移)、~(取反)、^(按位异或)、|(按位或)、&(按位与)；
    - 算数左移<<: 符号位不变，低位补0
    - 算数右移>>: 低位舍去，符号位不变，用符号位补溢出高位
    - 无符号右移>>>: 低位溢出，高位补0，不处理符号位，符号位跟着移动
    - 向左位移几位就是*几个2，右移动就是/(注意是/就是求商不要余数的意思)
    - ^不同为真,相同为假
- 原码、反码、补码：(重点)
    - 二进制的最高位表示符号：0表示＋，1表示-
    - 正数的原码，反码，补码都一样(三码合一)
    - 负数的反码=原码符号位不变(1)，其他位取反(0变1，1变0)
    - 负数的补码=负数的反码+1，负数的反码=负数的补码-1
    - 0的反码，补码都是0
    - java的数都是有符号的
    - 计算机运算的时候，都是以**补码**的方式来运算的
    - 看运算结果的时候，要看他的**原码**

## 第三章节: 控制结构(Chapter3)
### 7、分支控制(if else switch)
- 单分支(if) 双分支(if else) 多分支(if else if else if)
- switch分支结构，表达式，case 常量，当表达式=常量时执行对应代码块
    - 在每个case中最好都加上一个break，否则会直接执行后续case中的语句块代码，并且并不会判断后续case是否成立(穿透现象)
    - 表达式 的数据类型应当与常量的类型一致， 或者可以自动转换为可以相互比较的类型
    - 表达式中的返回值只可以是以下类型: byte、short、int、char、enum(枚举)、String
    - case中的值必须是常量或者常量表达式(2+3), 不能是变量
### 8、循环控制
- for循环控制可以将循环变量的定义放在循环体外(这样循环体外也可以获取循环变量)；循环变量改变也可以放在循环体内部，不过主要for(;;)中分号不可省略；for(;;i++,j++),在循环变量的迭代部分可以同时对多个变量迭代。
- while循环：循环变量在外部定义，循环变量的迭代在循环体内部
- do{}while(); 先执行后判断，至少执行一次
- break语句的细节：
    - 当break出现在多层嵌套的语句块中时可以通过标签指明要终止的那一层语句
    - 如果没有指定标签，则break是跳出最近一层循环体.
- continue语句的细节:
    - continue在多层嵌套的语句块中时也可以使用标签，之明回到那一层的继续循环
    - 如果没有指定标签，则continue是继续最近一层循环体.

## 第四章节: 数组、排序、查找(Chapter4)
### 9、数组
- 数组(引用数据类型): 将多个同一类型的数据放在一起
- 数组定义一(静态初始化): 变量类型[] 变量名 = {值1，值2}; 定义数组同时给定值, 其中[]也可以挪到变量名后边
- 数组定义二(动态初始化): 变量类型[] 变量名; 变量名 = new 变量类型\[数组长度]; 声明数组，创建数组长度(分配空间)
    - 变量名\[下标] = 值；采用这种方式给数组中每个位置赋值。
    - 动态初始化中可以将声明数组和创建数组长度(分配空间)合并到一起：变量类型[] 变量名 = new 变量类型\[数组长度]
- 注意事项:
    - 数组中的数值需要与数值声明的类型一致，或者是可以进行自动类型转换的类型。
    - 数组中也可以放引用数据类型(对象)
    - 数组创建后如果没有赋值，则有默认值: boolean-false, String-null, int-0, char-\u0000
    - 数组下标从0开始,下标最大值是长度-1
    - 数组型数据本质是对象
- 数组赋值机制
    - 数组的赋值方式为引用传递 arr1 = arr2 传递的是arr2的地址
- 数组扩容:
    - 创建一个新数组，长度为原来数组长度+1，将原来数组赋值给新数组，将增加的元素赋值给新数组的最后一位
    - 将新数组地址赋值给原来变量(没有变量引用旧数组，旧数组地址所在空间会被回收)
- 二维数组的内存形式
    - 在堆中开辟一个一维数组，存放的是地址，每个地址对应的是堆中另一个一维数组，这个一维数组才是真正存放数据的
    - 可以动态分配地址所指向的数据空间大小，int[][] arr = new int\[3][]，此时并没有开辟出存放数据的空间，因此我们可以开辟不同空间大小
        - arr[0] = new int[1]; arr[1] = new int[2] ; arr[2] = new int[3];给每个地址开辟独立的数据空间
    - 在二维数组的静态初始化时也可以根据一维数组的长度不同而不同赋值。

## 第五章节: 类、对象、方法(Chapter5)
### 10、类
- 通过class可以创建出一个对象，在对象中可以定义需要的属性，通过Cat 变量名 = new Cat()创建对象；我们也可以先声明再new，当我们new的时候才会在**堆**中开辟数据空间,并得到地址。
- Java内存结构介绍：
    - 栈：一般存放局部变量，基本数据类型
    - 堆：存放对象的数据空间(数组，引用类型)
    - 方法区：常量池(存放常量,比如字符串)，类的加载信息
    - 类信息在**方法区**只会加载一次
- 对象的内存布局: 
    - 对象的本质是引用类型
    - 在创建对象时会在**栈**创建一个地址，对象名指向这个地址；该地址是**堆**中开辟的一个数据空间，这个数据空间存放的是对象所拥有的属性数据(因此说真正的对象其实是在**堆**中)，如果属性的类型是字符串(引用类型)则**堆**中存储的就是地址，如果属性的类型是基本数据类型则**堆**中存储的就是真实数据了；如果**堆**中存储的是地址，则该地址就是指向真实数据位置。
    - 在new Cat()的时候**方法区**中常量池里将会加载Cat的信息包括有1、属性信息。2、方法信息
- 属性: 也被成为成员变量，一个类的属性可以是基本数据类型，也可以是引用类型(数组，对象)
    - 属性的定义: 访问修饰符(控制属性的访问范围public、private、protected) 属性类型 属性名
    - 属性没有赋值则会存在默认值: boolean-false, 引用类型-null, int-0, char-\u0000

### 11、对象
- 对象在new的时候，会在**堆**中开辟一个数据空间存放的对象所拥有的属性的地址/真实数据，并返回该空间的地址到**栈**中，对象名在栈中指向这个地址。此时在**堆**中的那个数据空间里都是默认值(null, 0)，当使用“对象.属性 = xxx”赋值时,**堆**中数据空间的数据会更新
- p2 = p1：是赋值的是**栈**中的地址，换句话说p2指向的**堆**的数据空间和p1是一样的，因此改变p2和p1其实就是同一个对象。(跟数组一样)

### 12、方法
- 方法的调用机制：p1.getSum(12,10)
    - 当执行getSum方法时会在**栈**中再开辟一个独立的空间，在这个独立空间里会将12赋值给n1，10赋值给n2(注意由于实参是一个基本数据类型所以此处的赋值是真实赋值，如果是引用类型此处的赋值其实是赋值的是**堆**中的地址)
    - 当执行到return时，会将结果返回给**main栈**中对应位置，并退出这个**独立栈空间**。
- 方法只能返回一个值，但我们可以返回一个数组，数组里放多个数据的结果。
- 如果方法定义时void没有返回值，我们可以return，也可以不用return, 但需要保证没有return后没有东西。
- 方法体中不能再定义方法。
- 同一个类中可以互相调用，不用使用对象.方法名的方式。
- 方法的传参机制：
    - 对于基本数据类型，传递的是值拷贝，形参的任何变化不影响实参！
    - 对于引用类型(数组)的传递，传递的是地址(真正的数据仍在**堆**中)，因此形参的变化会影响实参！
- 拷贝一个对象我们可以在方法中新生成一个对象，将属性进行从新赋值，要注意的是此时的赋值也遵循着：基本类型值拷贝，引用类型传递地址。(具体案例参看Object01.java)
- 递归中需要注意的事项：
    - 如果在递归中传递的是引用类型，就会共用该对象
    - 递归必须无线向递归条件逼近，否则会报错StackOverflowError
- 方法的重载：允许同一个类中，多个同名方法的存在，但要求形参的列表要不同
    - 形参个数,类型,类型顺序不同即为重载(至少有一个不同)
    - 对返回类型没有要求
    - 发生自动转换才能匹配上形参的方法 比 直接匹配上形参的方法 调用优先级低
- 可变参数：同名同功能但参数个数不同的方法，封装成一个方法
    - 可变参数的实参可以直接是数组。
    - 一个方法中只能指定一个可变参数, 并且可变参数必须在普通参数最后。
- 作用域
    - 局部变量: 成员方法中定义的变量，代码块(用{}来)中定义的变量
    - 局部变量只能在定义它的代码块中才能使用
    - 全局变量(属性变量)可以在整个类中都可以使用这个属性。
    - 全局变量(属性)可以不赋值即可使用，因为有默认值
    - 局部变量必须赋值后才能使用，因为默认值
    - 属性和局部变量可以重名，具体使用时会遵循就近原则
    - 在一个作用域的中局部变量不可以重名，不同的作用域中可以重名
    - 注意事项:
        - 属性可以通过对象调用在其他属性中访问到; 而局部变量只有在定义它的代码块中使用，其他地方不能被使用
        - 属性的声明周期长，随着属性的销毁而销毁；局部变量在代码块执行完毕即销毁
        - 局部变量不可以加 修饰符(public...)
- 构造器
    - 构造器的修饰符可以是public, private, protected, 默认
    - 构造器名称必须与类名保持一致，构造器没有返回值, 也不能写void!
    - 构造器的调用由系统完成，构造器的主要作用是对新对象的初始化.
    - 注意事项
        - 一个类可以定义多个构造器(构造器的重载)
        - 如果一个类没有定义构造器，则系统会默认无参构造器(使用javap指令可以对.class文件进行反编译)
        ```
        Dog(){

        }
        ```
        - 一但定义了构造器则不会再使用无参构造器了(即不能再使用new Person1()进行对象定义)，除非自己再定义一个无参构造器 
    - 对象创建内存分析：
        - 第一步: 将类信息加载到**方法区**
        - 第二步: 在**堆**中开辟空间，将属性初始化为默认值
        - 第三步: 如果属性有定义值则将定义的值赋予属性
        - 第四步: 如果存在构造器，则执行构造器内容
        - 第五步: 将**堆**中对象的地址赋给**栈**中的对象名变量(对象的引用)。完成
- this关键字
    - java虚拟机会给每个对象分配this，代表的是当前对象。
    - this.name表明的就是当前类的属性name, 这样可以在构造器中定义和属性名相同的局部变量名
    - 在**堆**中创建的每个对象都存在一个隐藏属性叫做this，这个this是指向的对象本身在**堆**的地址。(这个this在对象在堆中创建时就会被创建)
    - 注意事项:
        - this可以访问本类的属性、方法、构造器
        - this想调用构造器则只能在构造器中调用另一种构造器, this(参数列表)。并且有this访问构造器的语法，则必须放在第一条语句，且只能用一个this(参数列表)
        - this只能在类的方法中使用


## 第六章节: 修饰符(Chapter6)
### 13、包介绍
- 区分相同名字的类、当类有很多时可以很好的管理类、控制访问范围
- 本质: 创建不同的文件夹保存类文件
- 使用: package 包名: 表明当前类是在那个包下，表示打包，将下面写的类打包
- 包的命名规范: 
    - 不能以数字开头, 不能是关键字/保留字
    - com.公司名.项目名.模块名(例如: com.sina.crm.user)
- 常用的包:
    - java.lang.*: 基本包不需要import导入,可以直接使用
    - java.util.*: 系统提供的工具包, 工具类，例如Scanner
    - java.net.*: 网络开发
    - java.awt.*: 界面开发, GUI
- 导入包的方式:
    - import 包名.类名 : 只引入包中的单独一个类
    - import 包名.*   : 导入包中的所有类
- 包的注意事项:
    - package的作用是声明当前类所在的包，需要放在class的最上面, 一个类中最多只有一句package
    - 需要注意编译时需要在顶层目录下

### 14、访问修饰符
- 用于控制方法和属性的访问权限和范围
    - 公开级别public: 对外公开
    - 受保护protected: 对子类或同一个包中的类公开
    - 默认级别: 向同一个包的类公开
    - 私有级别Private: 只有类的内部可以使用
- 注意: 类的访问修饰符只有两个。默认 和 public

### 15、封装
- 把抽象出的数据(属性)和对数据(属性)的操作(方法)封装在一起，数据被保护在内部，程序的其他部分只有通过授权的操作(方法)，才能对数据进行操作
- 封装实现的步骤:
    - 先将属性私有化private
    - 提供一个public方法 set : 用于对属性的判断并赋值。在这个方法中加入数据验证的业务逻辑
    - 提供一个public方法 get : 用于获取某个属性的值。在这个方法中可以加入权限的验证
- 将构造器与set方法相结合。在构造方法中调用set方法

### 16、继承
- 当两个类的属性和方法有很多是相同的，此时代码为提高代码复用性，我们可以使用**继承**的特性
- 例如B类和C类有很多的属性和方法一致，我们可以创建一个A类，在A类中写好BC类共有的方法。在B,C类中使用extends关键字继承A类中的属性和方法
- protected 修饰的方法和属性 可以被不同包的子类访问(注意此处是被子类访问，而不是通过子类对象访问)
- 父类通过开放public方法类访问私有属性。这个public方法可以被子类继承，从而可以通过子类对象也可以访问到这个方法。
- 细节：
    - 子类继承了所有的**非私有**的属性和方法，非私有的属性和方法可以**在子类直接访问**(在子类直接访问 != 通过子类对象访问)
    - 子类必须调用父类的构造器，完成父类的初始化。(默认的时候，子类任意的构造器都会调用父类的无参构造器，super()会被默认放在子类构造器的第一步)，注意如果子类构造器中的第一句是this(...)那么只会执行this而不会执行super了，因为this()和super()都是在第一位。
    - 如果父类不存在无参构造器，则在子类的每个构造器第一句都必须指定使用super(参数列表)来指定父类的哪个有参构造。有父才有子
    - 我可以显式的调用父类构造器，使用super(参数列表)，此时不会再调用super(), 父类构造器只能调用一个。
    - super()必须放在子类构造器的第一行。注意此时也与this()冲突了，因为this也必须放在第一行。所以this和super不能共存
    - Object是所有类的父类。
    - 父类构造器的调用不限于直接父类，可以追溯到顶级父类Object
    - 一个类只能直接继承一个父类(即只能extend 1个类)
- 继承的本质: 当子类对象建立后，实质上是建立了查找关系。
    - 第一步: 当子类对象被创建的时候，在方法区会依次加载顶级父类-...-直接父类-子类的类信息
    - 第二步: 在**堆**中开辟子类对象空间，并且将顶级父类至直接父类的属性分别在开辟空间中存储(即使属性名相同但仍可以加载，因为每个等级父类的父类都会开辟独立的空间存储该父类的属性和方法), 总的来说就是每个等级的父类都在执行对象开辟的第一至第三步,在单独空间中。
    - 当我们通过子类对象访问某个属性时，会根据就近原则先查找子类中是否有该属性且可以访问，如果有则返回。如果没有则向上查找直接父类中是否存在该属性且可以访问，如果还没有找到则继续向上查找间接父类....直到找到顶级父类Object，都没有找到可以访问的该属性，则报错。在查找过程中只要有一个类中找到了该属性，但属性不可访问则也会直接报错(不可访问不会继续向上找了。)
- super关键字: 用于访问父类的属性、方法、构造器(前面已经提到过了)
    - super.属性名: 访问父类的属性，但不能访问父类的private属性(默认权限的属性也无法在其他包访问到)
    - super(): 调用父类构造器，只能放在子类构造器中的第一句位置，其他位置步可以
    - super.方法名(): 调用父类的方法，但不能调用父类的private方法，外包子类无法调用默认权限的方法。
    - 如果父类和子类的属性名或方法名重复，需要使用super.或者this.来明确指代调用的父类或者子类的方法或属性。如果没有指代，则查找方法根据就近原则(跟内存找属性是一个意思)
    - 注意: 使用super.方法名()/super.属性名，则会跳过查找本类的方法/属性, 直接从父类查找开始，后续查找流程是不变。
- this和super的区别就是确定开始查找的起始点，this的起始点是本类开始查找，super的起始点是父类开始查找(跳过子类)，查找的原则都是就近原则(直到找到最近父类存在，如果中途出现权限不足则直接中断查找，报错)

### 17、方法重写/覆盖(override)
- 子类有一个方法和父类的某个方法的名字、返回类型、参数列表都"一样"，则我们说子类这个方法覆盖了父类的方法。
- 注意事项:
    - 子类重写父类方法必须保证: 参数列表、方法名完全相同，子类的返回类型和父类的返回类型一致或者父类返回类型是子类返回类型的父类(例如父类返回类型是Object，则子类的返回类型可以是Object的子类即可) (父类的返回类型一定要兼容子类)
    - 子类方法不能缩小父类的访问权限: public > protected > 默认 > private。可以增大。
- 重写和重载的区别
    - 重载一般发生在本类，重写一般发生在子-父类
    - 方法名都必须一样
    - 重载的参数列表类型，个数，顺序至少有一个不同；重写必须相同
    - 重载对返回类型没有要求；重写时子类返回类型需要和父类相同或者是父类返回类型的子类
    - 重载对修饰符没有要求，重写时子类修饰符不能比父类修饰符的范围小(可以大)

### 18、多态
- 情景：主人(类)给宠物(类)用食物(类)喂食(feed方法)，feed方法中我们需要根据不同宠物喂食不同食物。例如:我们需要给猫(宠物子类)喂食鱼肉(食物子类)，我们需要给狗(宠物子类)喂食骨头(食物子类)，那么在写feed方法时我们需要写如下代码:
```
// 给狗喂食骨头
public void feed(Dog dog, Bone bone){
    ...
}

// 给猫喂食鱼肉
public void feed(Cat cat, Fish fish){
    ...
}

// 如果需要给其他动物(宠物的子类)，喂食其他的食物(食物的子类)
public void feed(... , ...){
    ...
}
```
从上述情境中我们可以看到，当更换了不同的食物子类或者宠物子类时，我们都需要重写一个feed方法，这显然是不利于维护的，因此引出了多态。
- 多态: 方法和对象具有多种形态
- 方法的多态
    - 方法的重载是典型的例子。传入不同的参数，就会调用不同的say()方法，体现了say()的多种形态。
    - 方法的重写是典型的例子。调用say()方法会自行定位调用的子类方法和父类方法
- 对象的多态
    - **重要总结**: 
        - 一个对象的编译类型和运行类型可以不一致(可以让父类的引用指向子类的对象 Animal an = new Dog(), an是在**栈**中的一个对象的引用，存放的是真实对象的地址。而真实对象是在**堆**中是一个Dog类。此时an的编译类型是Animal，运行类型是Dog)
        - 编译类型在定义对象时就确定了，不能更改。运行类型是可以变化的(an = new Cat(), 此时的运行类型变成了Cat, 编译类型仍然是Animal, an此时指想的是**堆**中Cat对象了)
        - 编译类型看定义时 = 的左边，运行类型看 = 号右边。
        - 执行时，看运行类型。编译类型是约束，执行类型是行为，所有的行为都需要在约束中。
- 多态的细节
    - 多态前提:两个对象(类)存在继承关系
    - 向上转型:父类的引用指向了子类对象(例如:Animal an = new Dog()); 
        - 父类类型 引用名 = new 子类类型(); 此处的父类可以是直接父类也可以是简介父类。
        - 特点: 可以调用父类中的所有成员(需要遵循访问权限); 不能调用子类中特有的方法。因为在编译阶段(javac)能调用那些成员是由编译类型决定的
        - 最终的实现效果是看子类(运行类型)的具体实现。(从子类开始"就近原则"进行查找)
    - 向下转型: 将父类引用(an)强制转换为子类引用(子类类型 引用名 = (子类类型) 父类引用)
        - 只能强制转换父类的引用，不能强制转化父类的对象(对象始终储存在**堆**中)。
        - 当前父类的引用必须指向的是当前目标类型的对象.
        - 当向下转型后，可以调用子类中所有代码了
    - 属性没有重写的说法，属性的值看**编译类型**。(如果子类和父类具有同名属性name，如果向上转型后, 父类引用an指向子类对象, an.name返回的将是父类的name)。【属性运行结果看编译类型, 方法运行结果看运行类型, 因为属性没有动态绑定机制】
    - istanceOf比较操作符: 用于判断对象的类型是否为xx类型，也可以判断是否为xx类型的子类型
        - 此处判断的对象类型是指**运行类型**。
        - "a == b" 判断的是引用a和引用b指向的地址是否相同
- **动态绑定机制**
    - 当对象调用方法时, 所有方法(无论那个位置的方法)会和该对象的**运行类型**(也就内存地址)绑定，也就是说所有的方法的调用都是从**运行类型**的类开始查找方法。
    - 属性**没有动态绑定机制**, 即哪里申明哪里使用, 在当前类查找(根据就近原则查找即可)









    - Demo10：类的定义，静态方法(static)、非静态方法的介绍
        - Demo10.java
        - Student.java
    - Demo11：子类，父类的方法调用，继承的介绍
        - Demo11.java
        - Person.java
        - Teacher.java
    - Demo12：方法的重写(覆写)
        - A.java
        - B.java
    - Demo13：多态的介绍
        - Person.java
        - Teacher.java
    - Demo14：抽象类/抽象方法的介绍
    - Demo15：接口
    - Demo16：异常捕获与处理
