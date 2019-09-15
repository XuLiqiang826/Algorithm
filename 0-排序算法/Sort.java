import java.util.*;
public class Sort{
	
	/**
     * ð������
     *
     * @param array
     * @return
	 ��������T(n) = O(n)   
	 ��������T(n) = O(n2)   
	 ƽ�������T(n) = O(n2)
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }
	
	/**
     * ѡ������
     * @param array
     * @return
	 ��������T(n) = O(n2)  
	 ��������T(n) = O(n2)  
	 ƽ�������T(n) = O(n2)
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //�ҵ���С����
                    minIndex = j; //����С������������
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
	
	/**
     * ��������
     * @param array
     * @return
	 ��������T(n) = O(n)   
	 ������T(n) = O(n2)   
	 ƽ�������T(n) = O(n2)
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
	
	/**
     * ϣ������
     *
     * @param array
     * @return
	�Ƚ�����������ļ�¼���зָ��Ϊ���������зֱ����ֱ�Ӳ������򣬾����㷨������
	ѡ��һ����������t1��t2������tk������ti>tj��tk=1��
	���������и���k�������н���k ������
	ÿ�����򣬸��ݶ�Ӧ������ti�����������зָ�����ɳ���Ϊm �������У��ֱ�Ը��ӱ����ֱ�Ӳ������򡣽���������Ϊ1 ʱ������������Ϊһ�������������ȼ�Ϊ�������еĳ��ȡ�
	��������T(n) = O(nlog2 n)  
	������T(n) = O(nlog2 n)  
	ƽ�������T(n) =O(nlog2n)��
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
	
	/**
     * �鲢����
     *
     * @param array
     * @return
	 ��������T(n) = O(n)  
	 ��������T(n) = O(nlogn)  
	 ƽ�������T(n) = O(nlogn)
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * �鲢���򡪡�����������õ������ϳ�һ����������
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
	
	/**
     * �������򷽷�
     * @param array
     * @param start
     * @param end
     * @return
	 ��������T(n) = O(nlogn)   
	 ��������T(n) = O(n2)   
	 ƽ�������T(n) = O(nlogn)��
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * ���������㷨����partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    /**
     * ��������������Ԫ��
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
	//����ȫ�ֱ��������ڼ�¼����array�ĳ��ȣ�
static int len;
    /**
     * �������㷨
     *
     * @param array
     * @return
	 ��������T(n) = O(nlogn) 
	 ��������T(n) = O(nlogn) 
	 ƽ�������T(n) = O(nlogn)
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.����һ������
        buildMaxHeap(array);
        //2.ѭ��������λ�����ֵ����ĩλ������Ȼ�������µ�������
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    /**
     * ��������
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //�����һ����Ҷ�ӽڵ㿪ʼ���Ϲ�������
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }
    /**
     * ����ʹ֮��Ϊ����
     *
     * @param array
     * @param i
     */ 
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //������������������������ڸ��ڵ㣬�����ָ��ָ��������
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //������������������������ڸ��ڵ㣬�����ָ��ָ��������
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //������ڵ㲻�����ֵ���򽫸��ڵ������ֵ���������ҵݹ�����븸�ڵ㽻����λ�á�
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }
	
		 
	 /**
     * ��������
     *
     * @param array
     * @return
	 �㷨����

	�ҳ��������������������С��Ԫ�أ�
	ͳ��������ÿ��ֵΪi��Ԫ�س��ֵĴ�������������C�ĵ�i�
	�����еļ����ۼӣ���C�еĵ�һ��Ԫ�ؿ�ʼ��ÿһ���ǰһ����ӣ���
	�������Ŀ�����飺��ÿ��Ԫ��i����������ĵ�C(i)�ÿ��һ��Ԫ�ؾͽ�C(i)��ȥ1
	
	 �������Ԫ����n ��0��k֮�������ʱ����������ʱ���� O(n + k)�����������ǱȽ�����������ٶȿ����καȽ������㷨��������������������C�ĳ���ȡ���ڴ��������������ݵķ�Χ�����ڴ�������������ֵ����Сֵ�Ĳ����1������ʹ�ü�������������ݷ�Χ�ܴ�����飬��Ҫ����ʱ����ڴ档
	 ��������T(n) = O(n+k)  
	 ��������T(n) = O(n+k)  
	 ƽ�������T(n) = O(n+k)
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }
	
	/**
     * Ͱ����
     *
     * @param array
     * @param bucketSize
     * @return
	 �㷨����

	��Ϊ����һ��BucketSize����Ϊÿ��Ͱ���ܷ��ö��ٸ���ͬ��ֵ�����統BucketSize==5ʱ����Ͱ���Դ�ţ�1,2,3,4,5���⼸�����֣������������ޣ������Դ��100��3����
	�����������ݣ����Ұ�����һ��һ���ŵ���Ӧ��Ͱ��ȥ��
	��ÿ�����ǿյ�Ͱ�������򣬿���ʹ���������򷽷���Ҳ���Եݹ�ʹ��Ͱ����
	�Ӳ��ǿյ�Ͱ����ź��������ƴ�������� 
	
	��������T(n) = O(n+k)   
	��������T(n) = O(n+k)   ƽ
	�������T(n) = O(n2)
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // �ҵ����ֵ��Сֵ
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketCount == 1)
                bucketSize--;
            ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
            for (int j = 0; j < temp.size(); j++)
                resultArr.add(temp.get(j));
        }
        return resultArr;
    }
	
	/**
     * ��������
     * @param array
     * @return
	 ȡ�������е����������ȡ��λ����
	arrΪԭʼ���飬�����λ��ʼȡÿ��λ���radix���飻
	��radix���м����������ü�������������С��Χ�����ص㣩��
	
	 ��������T(n) = O(n * k)   ��������T(n) = O(n * k)   ƽ�������T(n) = O(n * k)
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.������������λ����
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }
	
	public static void main(String[] args){
		int[] a={45,23,61,52,13,51,48,35,65,14};
		int[] b=new int[10];
		b = Sort.insertionSort(a);
		for(int i=0;i<10;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		for(int i=0;i<10;i++)
			System.out.print(b[i]+" ");
		
		System.out.println();
		System.out.println("��������");
		
		int[] c={45,23,61,52,13,51,48,35,65,14};
		int[] d=new int[10];
		d = Sort.RadixSort(c);
		for(int i=0;i<10;i++)
			System.out.print(c[i]+" ");
		System.out.println();
		for(int i=0;i<10;i++)
			System.out.print(d[i]+" ");
		
	
	
	}
}
