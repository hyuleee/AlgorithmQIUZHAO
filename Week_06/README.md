
学习笔记


### 冒泡 N^2 稳定
嵌套循环，每次查看相邻元素如果逆序则交换 逐步将最大值放后面


```
public static int [] sort(int [] array){
  for(i=0;i<length-1;i++)
      for(j=i+1;j<length;j++)
      if(arrayVal[i]>arrayVal[j])
       {
               //置换位置
               temp=arrayVal[i];
               arrayVal[i]=arrayVal[j];
               arrayVal[j]=temp;
           }
  }
}

```

### 选择 N^2 不稳定
每次找最小值，放到待排序数组的起始位置


```
    public static void selectionSort(int[] array){
        for( int i=0; i<array.length; i++ ){
            int minIdx = i; //记录最小值的位置
            for( int j=i+1; j<array.length; j++ ){
                if( array[j]<array[minIdx] ){
                    minIdx = j;
                }
            }
            if( minIdx!=i ){
                int temp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = temp;
            }
        }
        print(array);
    }

```


### 插入 N^2 稳定
从前往后逐步构建有序序列；对于未排序数据 在已排序序列中从后向前扫描，找到相应位置插入

```
    public  static void insertionSort(int[] a){
          for(int i = 1 ; i < a.length; i++){
              int temp = a[i];
              int j = i - 1;
              while( j >= 0 && temp < a[j]){
                   a[j+1] = a[j];
                   j--;
              }  
              a[j+1] = temp;
     }

```


### 快速 NlogN 不稳定
数组取标杆pivot，将小元素放pivot左边，大元素放右例，然后依次对右边和左边的子数组继续快排，直到有序

```
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}
static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}

```

### 归并 NlogN 稳定
将长度为N的输入序列分为两个长度为n/2的子序列，对两个子序列分别采用归并排序 排序好后的子序列合并成最终序列

```
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }

```

### 堆 NlogN 不稳定
数组元素依次放入小顶堆 依次取出堆顶元素并删除


```

static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;
    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }
    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}
public static void heapSort(int[] array) {
    if (array.length == 0) return;
    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-) 
        heapify(array, length, i);
    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}

```

### Week06刷题记录


| 题号                                                                                                                  | 名称                                                                            | 难度     | 备注   | 次数    |
| ------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ------ | ---- | ---- |
| [64] | [最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/) | 🟡 中等  | -   |  2  |
| [120] | [三角形最小路径和](https://leetcode-cn.com/problems/triangle/) | 🟡 中等  | -   |  2  |
| [72] | [编辑距离](https://leetcode-cn.com/problems/edit-distance/) | 🔴️ 困难  | 转换为二维表格动规   |  2  |
| [91] | [解码方法](https://leetcode-cn.com/problems/decode-ways/) | 🟡 中等  | -   |  2  |
| [46] | [全排列](https://leetcode-cn.com/problems/permutations/) | 🟡 中等  | -   |  2  |
| [493] | [翻转对](https://leetcode-cn.com/problems/reverse-pairs/) | 🔴️ 困难  | 归并排序  |  2  |
| [56] | [合并区间](https://leetcode-cn.com/problems/merge-intervals/) | 🟡 中等  | -   |  2  |
| [242] | [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/) | 🟢 简单  | -   |  3  |
| [1122] | [数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array/) | 🟢 简单  | 思路巧妙   |  2  |
| [121] | [买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) | 🟢 简单  | 动态规划统一模板   |  2  |
| [64] | [最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/) | 🟡 中等  | 动态规划原有数组直接更改  |  2  |
| [198] | [打家劫舍](https://leetcode-cn.com/problems/house-robber/) | 🟢 简单  |  -  |  3  | 
| [62] | [不同路径](https://leetcode-cn.com/problems/unique-paths/) | 🟡 中等  | 动态规划优化为一维  |  2  |
| [84] | [柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/) | 🔴️ 困难  | 栈得出当前柱子的左右边界模板  |  2  |
| [85] | [最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/) | 🔴️ 困难  | -   |  1  |
| [32] | [最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/) | 🔴️ 困难  | 栈优化成左右各遍历一次  |  2  |
| [300] | [最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/) | 🟡 中等  | dp定义为当前位置为绝对大时的最长子序列  |  2  |
| [746] | [使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/) | 🟢 简单  | 三行动规   |  2  |
| [387] | [字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/) | 🟢 简单  | 数组代替hash  |  2  |
| [14] | [最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/) | 🟢 简单  | 对齐从头开始比较  |  2  |
| [344] | [反转字符串](https://leetcode-cn.com/problems/reverse-string/) | 🟢 简单  | 双指针头尾向中靠齐  |  2  |
| [49] | [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) | 🟡 中等  | 排序后hash映射  |  0  |
| [8] | [字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/) | 🟡 中等  | 判断溢出和正负号  |  2  |
| [151] | [翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/) | 🟡 中等  | 分割字符串  |  1  |
| [438] | [找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/) | 🟡 中等  | 双指针滑动数组窗口  |  1  |
| [1143] | [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/) | 🟡 中等  | -  |  2  |
| [5] | [最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/) | 🟡 中等  | 双指针往前往后动规及时更新输出  |  2  |
| [115] | [不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/) | 🔴️ 困难  | 子序列不可减少   |  2  |
