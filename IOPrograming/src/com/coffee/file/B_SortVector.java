package com.coffee.file;

import java.util.Vector;
/**
 * 排序java1.0和1.1库都缺少的一样东西是算数运算，甚至没有最简单的排序运算方法。因此，我们最好创建一个Vector,利用经典
 * 的Quicksort(快速排序)方法对其自身进行排序。
 * 编写通用的排序代码时，面临的一个问题是必须根据对象的实际类型来执行比较运算，从而实现正确的排序。当然，一个办法是为了每种不同的类型都写一个不同的排序方法。
 * 然而，应认识到假若这样做，以后增加新类型时便不易实现代码的重复利用。
 * 程序设计一个主要的目标就是“将发生变化的东西保持不变的东西分隔开”。在这里，保持不变的代码时通用的排序算法，而每次使用时都要变化的是对象的实际比较方法。因此，我们
 * 不可将比较代码“硬编码”到多个不同的排序例程内，而是采用“回调”技术。利用回调，经常发生变化的那部分代码封装到它自己的类内，而总是保持相同的代码则“回调”发生变化的
 * 代码。这样一来，不同的对象就可以表达不同的比较方式，同时向他们传递相同的排序代码。
 * 
 * 可以创建Vector的一个子类，通过Compare实现“快速排序”。
 * @author Administrator
 *
 */
//Interface for sorting callback;
interface Compare {
	boolean lessThan(Object lhs, Object rhs);
	boolean lessThanOrEqual(Object lhs, Object rhs);
}

public class B_SortVector extends Vector {
	private Compare compare;//to hold the callback
	public B_SortVector(Compare comp) {
		compare = comp;
	}
	public void sort() {
		quickSort(0,size() - 1);
	}
	private void quickSort(int left,int right) {
		if(right > left) {
			Object o1 = elementAt(right);
			int i = left - 1;
			int j = right;
			while(true) {
				while(compare.lessThan(elementAt(++i), o1))
					;
				while(j>0)
					if(compare.lessThanOrEqual(elementAt(--j), o1))
						break;//out of while
					if(i >- j) break;
					swap(i,j);
			}
			swap(i,right);
			quickSort(left, i-1);
			quickSort(i+1, right);
		}
	}
	private void swap(int locl, int loc2) {
		Object tmp = elementAt(locl);
		setElementAt(elementAt(loc2),locl);
		setElementAt(tmp,loc2);
	}
}
