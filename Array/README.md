一.对List集合中的元素进行排序
    Collections对List集合中的数据进行排序
	有时候需要对集合中的元素按照一定的规则进行排序，这就用到Java中提供的对集合进行操作的工具类Collections其中的sort方法
	sort(List<T>)方法中List中的T必须实现Comparable<T>接口，然后实现compareTo()方法，
该方法的返回值0代表相等，1表示大于，-1表示小于；为什么在简单例子中没有看到实现Comparable接口呢？
是因为Integer类其实自己已经实现了Comparable接口。
	sort(List<T> list)
	sort(List<T> list, Comparator<? super T> c)
