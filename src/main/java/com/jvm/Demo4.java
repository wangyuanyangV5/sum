package com.jvm;
/**
 * 大于3MB直接进入老年代
 * 0.068: [ParNew (promotion failed): 7611K->8364K(9216K), 0.0027295 secs]
 * 给array6分配空间时发现新生代不足，此时触发youngGC 且符合空间担保
 *
 * 0.070: [CMS: 8193K->6870K(10240K), 0.0029397 secs] 11707K->6870K(19456K),
 * [Metaspace: 223K->223K(4480K)], 0.0057882 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * 老年代有8MB，年轻代GC的时候放入了两个2MB的对象  4MB回收后放入了2MB+128KB
 */
public class Demo4 {
    public static void main(String[] args) {
        byte[] array1 = new byte[4 * 1024 * 1024];
        array1 = null;
        byte[] array2 = new byte[2 * 1024 * 1024];
        byte[] array3 = new byte[2 * 1024 * 1024];
        byte[] array4 = new byte[2 * 1024 * 1024];
        byte[] array5 = new byte[128 * 1024];


        byte[] array6 = new byte[2 * 1024 * 1024];
    }
}
