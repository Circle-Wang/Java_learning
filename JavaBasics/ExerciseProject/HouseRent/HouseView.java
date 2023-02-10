package ExerciseProject.HouseRent;

import java.util.HashMap;

// 显示界面
// 接收用户的输入
// 调用其他类完成对房屋的操作
public class HouseView {

    private boolean loop = true; // 用于控制菜单循环显示
    private char key;     // 用接收用户的选择
    private HouseService houseService = new HouseService();   // 用于房屋增删改查操作对象

    // 用于主界面的显示
    public void mainMenu() {

        // 类似零钱通的主界面显示
        do {
            System.out.println("\n===========房屋出租系统===========");
            System.out.println("\t1 新 增 房 源");
            System.out.println("\t2 查 找 房 源");
            System.out.println("\t3 删除房屋信息");
            System.out.println("\t4 修改房屋信息");
            System.out.println("\t5 房 屋 列 表");
            System.out.println("\t6 退      出");
            System.out.print("请输入你的选择(1-6):");
            key = Utility.readMenuSelection();  // 获取用户输入
            switch (key) {
                case '1':
                    addHouseView();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    showHouseList();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
        
    }

    // 房屋列表展示函数
    public void showHouseList() {
        HashMap<Integer, House> houses = houseService.getHouses();
        System.out.println("------------------房屋列表---------------------");
        System.out.println(String.format("%-6s%-6s%-10s%-6s%-10s%-6s","编号","房主","电话","地址","月租","状态(已出租/待出租)"));
        
        for (Integer key : houses.keySet()) {
            System.out.println(key + "\t" + houses.get(key));
        }
        System.out.println("--------------房屋列表显示完毕-----------------\n");
    }

    // 新增房源展示函数
    public void addHouseView() {
        System.out.println("------------------添加房屋---------------------");
        System.out.print("姓名:");
        String name = Utility.readString(8); // 读取最长8个字符串
        System.out.print("电话:");
        String phone = Utility.readString(8);
        System.out.print("地址:");
        String address = Utility.readString(8);
        System.out.print("租金:");
        double rent = Utility.readInt(8);
        System.out.print("状态:");
        String state = Utility.readString(6);
        House newHouse = new House(name, phone, address, rent, state);
        houseService.addHouse(newHouse);
        System.out.println("------------------房屋添加成功---------------------\n");
    }

    // 删除房屋显示函数
    public void delHouse() {
        System.out.print("请输入待删除房屋编号(输入-1退出): ");
        int delId; // 待删除房屋ID
        while (true) {
            delId = Utility.readInt();
            if (delId == -1) {
                System.out.println("------------------放弃删除房屋信息---------------------\n");
                return;
            } else if (! houseService.getHouses().keySet().contains(delId)) {
                System.out.print("输入房屋编号不存在请重新输入: ");
            } else {
                break;
            }
        }
        char choice = Utility.readConfirmSelection(); // 自动包含有提示信息,如果输入的不是Y/N则会被循环输入
        if (choice == 'Y') {
            houseService.deleteHouse(delId);
            System.out.println("------------------房屋信息删除成功---------------------\n");
        } else {
            System.out.println("------------------放弃删除房屋信息---------------------\n");
        }
    }

    // 完成退出确认显示函数
    public void exit() {
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            loop = false;
        }
    }

    // 查找房屋功能
    public void findHouse() {
        HashMap<Integer, House> houses = houseService.getHouses();
        System.out.println("------------------查找房屋---------------------");
        System.out.print("请输入待查找房屋编号(输入-1退出): ");
        int findId;
        while (true) {
            findId = Utility.readInt();
            if (findId == -1) {
                break;
            }
            House house = houses.get(findId);  // 如果不存在则会返回null
            if (house == null){
                System.out.print("输入房屋编号不存在请重新输入: ");
            } else {
                System.out.println("------------------房屋信息---------------------");
                System.out.println("编号\t房主\t电话\t地址\t月租\t状态(已出租/待出租)");
                System.out.println(findId + "\t" + house);
                break;
            }

        }
    }

    // 修改房屋信息功能
    public void updateHouse() {
        HashMap<Integer, House> houses = houseService.getHouses();
        System.out.println("------------------修改房屋---------------------");
        System.out.print("请输入待修改的房屋编号(输入-1退出): ");
        int findId;
        while (true) {
            findId = Utility.readInt();
            if (findId == -1) {
                break;
            }

            House house = houses.get(findId);  // 如果不存在则会返回null
            if (house == null){
                System.out.print("输入房屋编号不存在请重新输入: ");
            } else {
                System.out.println("请在:后直接输入修改后结果, 直接回车表示不修改");
                System.out.print(String.format("姓名(%s): ", house.getName()));
                house.setName(Utility.readString(8, house.getName()));
                System.out.print(String.format("电话(%s): ", house.getPhone()));
                house.setPhone(Utility.readString(8, house.getPhone()));
                System.out.print(String.format("地址(%s): ", house.getAddress()));
                house.setAddress(Utility.readString(8, house.getAddress()));
                System.out.print(String.format("租金(%f): ", house.getRend()));
                house.setRend(Utility.readInt((int) house.getRend()));
                System.out.print(String.format("状态(%s): ", house.getState()));
                house.setState(Utility.readString(8, house.getState()));
                System.out.println("------------------房屋修改成功---------------------");
                break;
            }


        }

    }
    
}
