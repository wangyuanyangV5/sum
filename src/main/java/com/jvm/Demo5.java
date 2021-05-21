package com.jvm;

/**
 * -XX:NewSize=10485760  -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760
 * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC  -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log -XX:+PrintHeapAtGC
 */
public class Demo5 {
    public static void main(String[] args) {
        byte[] array1 = null;
        byte[] array2 = null;
        byte[] array3 = null;
//        for(int i = 0;i < 6;i++){
//            array1 = new byte[3 * 1024 * 1024];
//            array1 = new byte[3 * 1024 * 1024];
//            array1 = new byte[ 512 * 1024];
//            array2 = new byte[ 512 * 1024];
//            array2 = null;
//            array3 = new byte[ 1024 * 1024];
//            array3 = null;
//        }
        array1 = new byte[ 512 * 1024];
        array2 = new byte[ 512 * 1024];
        array2 = null;
        array3 = new byte[ 1024 * 1024];
        array3 = null;
        array1 = new byte[3 * 1024 * 1024];
        array1 = new byte[3 * 1024 * 1024];


//        array1 = new byte[2 * 1024 * 1024];
//        array1 = new byte[2 * 1024 * 1024];
//        array1 = new byte[2 * 1024 * 1024];
//        array2 = new byte[128 * 1024];
//        array2 = null;
//        array3 = new byte[2 * 1024 * 1024];
//
//        try {
//            Thread.sleep(20000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
/**
 * Java HotSpot(TM) Client VM (25.181-b13) for windows-x86 JRE (1.8.0_181-b13), built on Jul  7 2018 03:18:20 by "java_re" with MS VC++ 10.0 (VS2010)
 * Memory: 4k page, physical 16617128k(5914564k free), swap 34442920k(13103304k free)
 * CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:MaxTenuringThreshold=15 -XX:NewSize=10485760 -XX:OldPLABSize=16 -XX:PretenureSizeThreshold=10485760 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintHeapAtGC -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -XX:-UseLargePagesIndividualAllocation -XX:+UseParNewGC
 * {Heap before GC invocations=0 (full 0):
 *  par new generation   total 9216K, used 7995K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,  97% used [0x04e00000, 0x055cede0, 0x05600000)
 *   from space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *   to   space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *  concurrent mark-sweep generation total 10240K, used 0K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * 0.067: [GC (Allocation Failure) 0.067: [ParNew: 7995K->1022K(9216K), 0.0013236 secs] 7995K->1127K(19456K), 0.0014396 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap after GC invocations=1 (full 0):
 *  par new generation   total 9216K, used 1022K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,   0% used [0x04e00000, 0x04e00000, 0x05600000)
 *   from space 1024K,  99% used [0x05700000, 0x057ff928, 0x05800000)
 *   to   space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *  concurrent mark-sweep generation total 10240K, used 104K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * }
 * {Heap before GC invocations=1 (full 0):
 *  par new generation   total 9216K, used 8862K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,  95% used [0x04e00000, 0x055a8210, 0x05600000)
 *   from space 1024K,  99% used [0x05700000, 0x057ff928, 0x05800000)
 *   to   space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *  concurrent mark-sweep generation total 10240K, used 104K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * 0.069: [GC (Allocation Failure) 0.069: [ParNew: 8862K->0K(9216K), 0.0032798 secs] 8967K->3681K(19456K), 0.0033149 secs] [Times: user=0.06 sys=0.02, real=0.00 secs]
 * Heap after GC invocations=2 (full 0):
 *  par new generation   total 9216K, used 0K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,   0% used [0x04e00000, 0x04e00000, 0x05600000)
 *   from space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *   to   space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *  concurrent mark-sweep generation total 10240K, used 3681K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * }
 * {Heap before GC invocations=2 (full 0):
 *  par new generation   total 9216K, used 5273K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,  64% used [0x04e00000, 0x05326778, 0x05600000)
 *   from space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *   to   space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *  concurrent mark-sweep generation total 10240K, used 3681K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * 0.072: [GC (Allocation Failure) 0.072: [ParNew: 5273K->0K(9216K), 0.0017583 secs] 8955K->6753K(19456K), 0.0017826 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap after GC invocations=3 (full 0):
 *  par new generation   total 9216K, used 0K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,   0% used [0x04e00000, 0x04e00000, 0x05600000)
 *   from space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *   to   space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *  concurrent mark-sweep generation total 10240K, used 6753K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * }
 * 0.074: [GC (CMS Initial Mark) [1 CMS-initial-mark: 6753K(10240K)] 10494K(19456K), 0.0007140 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 0.075: [CMS-concurrent-mark-start]
 * {Heap before GC invocations=3 (full 1):
 *  par new generation   total 9216K, used 5277K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,  64% used [0x04e00000, 0x05327580, 0x05600000)
 *   from space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *   to   space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *  concurrent mark-sweep generation total 10240K, used 6753K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * 0.075: [GC (Allocation Failure) 0.075: [ParNew: 5277K->5277K(9216K), 0.0000093 secs]0.075: [CMS0.077: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *  (concurrent mode failure): 6753K->1110K(10240K), 0.0033759 secs] 12031K->1110K(19456K), [Metaspace: 224K->224K(4480K)], 0.0034130 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap after GC invocations=4 (full 2):
 *  par new generation   total 9216K, used 0K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,   0% used [0x04e00000, 0x04e00000, 0x05600000)
 *   from space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *   to   space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *  concurrent mark-sweep generation total 10240K, used 1110K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * }
 * {Heap before GC invocations=4 (full 2):
 *  par new generation   total 9216K, used 7325K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,  89% used [0x04e00000, 0x055277d0, 0x05600000)
 *   from space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *   to   space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *  concurrent mark-sweep generation total 10240K, used 1110K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * 0.079: [GC (Allocation Failure) 0.079: [ParNew: 7325K->512K(9216K), 0.0004635 secs] 8436K->1622K(19456K), 0.0004864 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap after GC invocations=5 (full 2):
 *  par new generation   total 9216K, used 512K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,   0% used [0x04e00000, 0x04e00000, 0x05600000)
 *   from space 1024K,  50% used [0x05600000, 0x05680010, 0x05700000)
 *   to   space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *  concurrent mark-sweep generation total 10240K, used 1110K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * }
 * {Heap before GC invocations=5 (full 2):
 *  par new generation   total 9216K, used 8330K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,  95% used [0x04e00000, 0x055a2b08, 0x05600000)
 *   from space 1024K,  50% used [0x05600000, 0x05680010, 0x05700000)
 *   to   space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *  concurrent mark-sweep generation total 10240K, used 1110K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * 0.080: [GC (Allocation Failure) 0.080: [ParNew: 8330K->512K(9216K), 0.0004297 secs] 9441K->1622K(19456K), 0.0004511 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap after GC invocations=6 (full 2):
 *  par new generation   total 9216K, used 512K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,   0% used [0x04e00000, 0x04e00000, 0x05600000)
 *   from space 1024K,  50% used [0x05700000, 0x05780010, 0x05800000)
 *   to   space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *  concurrent mark-sweep generation total 10240K, used 1110K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * }
 * {Heap before GC invocations=6 (full 2):
 *  par new generation   total 9216K, used 8338K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,  95% used [0x04e00000, 0x055a4a30, 0x05600000)
 *   from space 1024K,  50% used [0x05700000, 0x05780010, 0x05800000)
 *   to   space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *  concurrent mark-sweep generation total 10240K, used 1110K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * 0.081: [GC (Allocation Failure) 0.081: [ParNew: 8338K->0K(9216K), 0.0007878 secs] 9449K->4183K(19456K), 0.0008109 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap after GC invocations=7 (full 2):
 *  par new generation   total 9216K, used 0K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,   0% used [0x04e00000, 0x04e00000, 0x05600000)
 *   from space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *   to   space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *  concurrent mark-sweep generation total 10240K, used 4183K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 * }
 * Heap
 *  par new generation   total 9216K, used 2364K [0x04e00000, 0x05800000, 0x05800000)
 *   eden space 8192K,  28% used [0x04e00000, 0x0504f340, 0x05600000)
 *   from space 1024K,   0% used [0x05600000, 0x05600000, 0x05700000)
 *   to   space 1024K,   0% used [0x05700000, 0x05700000, 0x05800000)
 *  concurrent mark-sweep generation total 10240K, used 4183K [0x05800000, 0x06200000, 0x06200000)
 *  Metaspace       used 224K, capacity 2280K, committed 2368K, reserved 4480K
 **/
