# JAVA8
some new features about java8. such as:Lambda &amp;StreamAPI

1. 预备知识

在了解Lambda表达式之前首先需要了解以下预备知识。

1.1 如何成为一名高级码农？

如果老板让你写一个用于毁灭地球的函数，而你写了一个毁灭行星的函数，若要毁灭地球只需将毁灭地球的过程传递给“毁灭行星”。能做到这一点，你就是一名高级码农。

以上这个问题体现了程序可扩展性的思想。总结一下，要成为一名高级码农，在编码的时候要以发展的眼光看待问题。一个具体问题到来的时候，你需要基于当前问题抽象出解决这一类问题的办法，那么当相似的问题到来时，你只需花少量的时间就能完成任务，而且避免了代码复制，降低了bug的风险。

1.2 实现程序可扩展性的例子

在Java8以前，要实现程序的可扩展性，我们常用匿名内部类传递用于扩展的代码，举个例子：

实现一个能从List集合中筛选指定对象的函数filter。 
1. 若List中存放Person对象，要求筛选出30岁以上的Person 
2. 若List中存放Apple，要求筛选出红色的Apple
使用匿名内部类的解决方案：如代码里所示：

1.5 什么是函数式编程？

所谓“函数式”编程，就是将函数的代码当作一个变量，传递给另一个变量或传递给一个函数，这种编程方式就称为“函数式编程”。 
Java8中采用Lambda表达式实现函数式编程，它是策略模式的第二种实现方式，目的就是简化策略模式的代码实现。

2. Lambda表达式的语法

Lambda表达式用于表示一个函数，所以它和函数一样，也拥有参数、返回值、函数体，但它没有函数名，所以Lambda表达式相当于一个匿名函数。语法如下：

(Person person)—>person.getAge()>30
1
> Lambda表达式用—>连接，->左侧为函数的参数，->右侧为函数体。 
> 若右侧由多条语句构成则需要用{}包裹，如：

> (Person person)—>{person.getAge()>30;System.out.println(person.getName());}
1
Lambda表达式无需显示指定返回值类型，JVM会根据->右侧语句的返回结果自动判断返回值类型，如：

(Person person)—>person.getAge()>30 #自动判断返回值为boolean
3. 如何使用Lambda表达式？

仍以筛选年龄大于30的Person对象为例：
3.1 为Lambda表达式定义函数式接口

@FunctionalInterface
interface FilterProcessor<T>{
    boolean process(T t);
}

PS：该接口只能有一个抽象函数！接下来Lambda表达式就是该抽象函数的实现。 
PS：在为Lambda表达式定义函数式接口时，需要加上注解@FunctionalInterface，这样当该接口中抽象函数个数不是1时就会报错提示。

3.2 实现筛选函数

List<T> filter(List<T> list, FilterProcessor<T> filterProcessor){
    List<T> result = new ArrayList<T>();
    if(filterProcessor.process(t))
        result.add(t);
    return result;
}

filter函数接收一个函数式接口，该参数用于接收一个Lambda表达式。

3.3 传递Lambda表达式

List<Person> result = filter(list, (Person p)->p.getAge()>30);
1
直接将Lambda表达式作为参数传递给filter的函数式接口即可，从而在result中就能获取年龄超过30岁的Person对象。

