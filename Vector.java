package Vector;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Vector<T> {
	private Object array[];
	private int LengthOfArray;
	public Vector() {
		array=new Object[0];
		LengthOfArray=0;
		
	}
	//add single element 1
	public synchronized boolean add(T element) {
		addElementMethod(element);
		return true;
	}
	
	public synchronized T[] addElementMethod(T element) {
		this.array=Arrays.copyOf(array, LengthOfArray+1);
		array[array.length-1]=element;
		LengthOfArray=array.length;
		return (T[])array;
	}
	
	
	//add element with index 2
	public boolean add(int index,T element) {
		addElementMethod(index,element);
		return true;
	}
	
	public synchronized T[] addElementMethod(int index,T element) {
			if(LengthOfArray<index) {
				throw new ArrayIndexOutOfBoundsException();
			}
			Object[] arr1=Arrays.copyOfRange(array,0,index);
			Object[] arr2=Arrays.copyOfRange(array,index,array.length);
			array=Arrays.copyOf(array, LengthOfArray+1);
			LengthOfArray=array.length;
			for(int i=0;i<arr1.length;i++) {
				array[i]=arr1[i];
			}
			
			array[index]=element;
			int j=0;
			for(int i=index+1;i<array.length;i++) {
				array[i]=arr2[j];
				j++;
			}
	

		return (T[]) array;
		
		
	}
	
	//add all the element 3
	public synchronized boolean addAll(Collection<? extends T> c) {
		Object[] arr=c.toArray();
		int len=array.length;
		array=Arrays.copyOf(array, LengthOfArray+arr.length);
		LengthOfArray=array.length;
		int j=0;
		for(int i=len;i<array.length;i++) {
			array[i]=arr[j];
			j++;
		}
		return true;
	}

	//add all the element with start index 4
	public synchronized boolean addAll(int index,Collection<? extends T> c) {
		if(LengthOfArray<index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Object[] arr=c.toArray();
		int len=arr.length;
		Object[] arr1=Arrays.copyOfRange(array,0,index);
		Object[] arr2=Arrays.copyOfRange(array,index,array.length);
		array=Arrays.copyOf(array, LengthOfArray+len);
		LengthOfArray=array.length;
		for(int i=0;i<arr1.length;i++) {
			array[i]=arr1[i];
		}
		int j=0;
		for(int i=index;i<index+arr.length;i++) {
			array[i]=arr[j];
			j++;
		}
		j=0;
		for(int i=index+arr.length;i<array.length;i++) {
			array[i]=arr2[j];
			j++;
		}

		return true;
	}
	
	//add Element in the vector similar to add 5
	public boolean addElement(T element) {
		addElementMethod(element);
		return true;
	}
	// gives length of the vector 6
	public int capacity() {
		return LengthOfArray;
	}
	
	//clear all the element from the vector 7
	public void clear() {
		array=new Object[0];
		LengthOfArray=0;
	}
	
	//clone the all the element to a object 8
	public synchronized Object clone() {
		 Vector<T> v=new Vector<T>();
		 for(int i=0;i<array.length;i++) {
			 v.add((T) array[i]);
		 }
			 return v;
		
	}
	//check whether the given element is present or not 9
	public boolean contains(Object obj) {
		return indexOf(obj,0)>0;
	}
	
	//gives the index of the vector with element and index as parameter 10
	public synchronized int indexOf(Object obj,int index) {
		if(obj==null) {
			for(int i=index;i<array.length;i++){
				if(array[i]==null) {
					return i;
				}
			}
		}else {
			for(int i=index;i<array.length;i++){
				if(array[i].equals(obj)) {
					return i;
				}
			}
		}
		return -1;
	}
	//containsAll check all the element from the collection present int the vector 11
	public synchronized boolean containsAll(Collection<?> o) {
		List<T> list=(List<T>) Arrays.asList(array);
			for(Object a:o) {
				if(!list.contains(a)) {
					return false;
				}
			}
		return true;
	}
	
	//copies all the element of vector to the array 12
	public void copyInto(Object object[]) {
		System.arraycopy(array, 0, object, 0, LengthOfArray);
	}
	
	//getting the element from the particular index 13
	public synchronized T elementAt(int index) {
		if(LengthOfArray<=index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return (T) array[index];
	}
	
	//return the first element 14
	public T firstElement() {
		return (T) array[0];
	}
	
	//get the element with particular index 15
	public T get(int index) {
		return (T) array[index];
	}
	
	//get the index of the element from the first index 16
	public int indexOf(Object obj) {
		return indexOf(obj,0);
	}
	//check the vector is empty 17
	public boolean isEmpty() {
		return LengthOfArray==0;
	}
	//give the last element 18
	public synchronized T lastElement() {
		return (T) array[LengthOfArray-1];
	}
	//remove the element from the array in particular index 19
	public T remove(int index) {
		if(LengthOfArray<index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T val=(T) array[index];
		Object[] arr1=Arrays.copyOfRange(array,0,index);
		Object[] arr2=Arrays.copyOfRange(array,index+1,array.length);
		array=Arrays.copyOf(array, LengthOfArray-1);
		LengthOfArray=array.length;
		for(int i=0;i<arr1.length;i++) {
			array[i]=arr1[i];
		}
		
		int j=0;
		for(int i=index;i<array.length;i++) {
			array[i]=arr2[j];
			j++;
		}
	return val;
	
	}
	
	//remove the element from the array in particular index 20
		public boolean remove(Object obj) {
			int i=indexOf(obj);
			if(i>=0) {
				remove(i);
				return true;
			}
			return false;
		
		}
		//return the length of the vector 21
		public int size() {
			return array.length;
		}
		
		//replace element at particular index and return that element 22
		public T set(int index,T element) {
			array[index]=element;
			return element;
		}
	//replace element at particular index 23
		public void setElementAt(T obj,int index) {
			array[index]=obj;
			
		}
		//return the object array of the vector 24
		public synchronized Object[] toArray() {
			return Arrays.copyOf(array, LengthOfArray);
		}
		
		//return the string of the vector 25
	public String toString() {
		return Arrays.toString(array);
	}
}
