package huawei;

import java.util.*;

public class CalLength {
    public static void main(String[] args) {
        //5
        //d3
        //d1 null d2
        //d1 null d3
        //d2 d1 null
        //d3 d1 d4
        //d4 d3 null
//        Scanner scanner = new Scanner(System.in);
//        //输入数据长度
//        int size = Integer.parseInt(scanner.nextLine());
//        String deviceId = scanner.nextLine();
//        String root = null;
//        //键为设备id，值为流入设备
//        Map<String, String> registry = new HashMap<>();
//
//        for (int i = 0; i < size; i++) {
//            String line = scanner.nextLine();
//            String[] records = line.split(" ");
//
//            if ("null".equals(records[1])) {
//                root = records[0];
//                registry.put(root,null);
//            }else {
//                registry.put(records[0], records[1]);
//            }
//
//            if (!"null".equals(records[2])) {
//                registry.put(records[2], records[0]);
//            }
//        }
        String deviceId = "d3";
        //键为设备id，值为流入设备
        Map<String, String> registry = new HashMap<>();
        registry.put("d1",null);
        registry.put("d2","d1");
        registry.put("d3","d1");
        registry.put("d4","d3");


        Map<String, Integer> res = maxPath(registry);
        System.out.println(res.get(deviceId));
    }

    public static Map<String, Integer> maxPath(Map<String, String> path) {
        //存放数据，键值为节点，值为最大路径。
        Map<String, Integer> result = new HashMap<>();
        //节点集合
        Set<String> devices = path.keySet();
        //遍历每个节点
        for (String device :
                devices) {
            int length = 1;
            String front = device;
            //存放此路径所有节点
            Set<String> deviceInPath = new HashSet<>();
            deviceInPath.add(device);

            for(;;) {
                //前方有一个节点则+1，直到到头
                front = path.get(front);
                if (front == null) {
                    break;
                }
                deviceInPath.add(front);
                length++;
            }

            // 更新路径中所有节点的最大路径
            Integer max;
            for (String s : deviceInPath) {
                //如果没有存过max就为初始化的length。
                max = result.getOrDefault(s, length);
                max = Math.max(max, length);
                result.put(s, max);
            }
        }

        return result;
    }
}
