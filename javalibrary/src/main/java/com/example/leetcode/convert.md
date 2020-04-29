算法中常用的转换
#### String 和其他类型的转换
* 数组转String`arr.toString()`
* String转数组`stringxxxx.toCharArray()`

* List转String`string.Join(",", list.ToArray())`;
* String转List先转成数组再转成List

#### 数组和List的转换
* 数组转List `Arrays.asList(result.getTb_name().split(","))`
* List转数组 `list.toArray(new String[]{});`

#### 二分查找终止条件的判断
就找临界点去看看挨着的地方是否能跑的通？如果跑的通说明二分查找的终止条件可以。