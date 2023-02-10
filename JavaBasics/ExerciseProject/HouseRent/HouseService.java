package ExerciseProject.HouseRent;

import java.util.HashMap;


// 完成对房屋信息的各种操作(CRUD增删改查)
// 完成功能方法的编写

public class HouseService {

    public int idCounter = 0; // 用于记录编号, 每次添加时自增长
    private HashMap<Integer, House> houses = new HashMap<>();  // 用于储存对象House对象的hashmap对象

    {
        houses.put(++idCounter, new House("王小虎", "123456", "重庆市", 2600, "待出租"));
        houses.put(++idCounter, new House("小李", "7562", "北京市", 56000, "已出租"));
    }


    public HashMap<Integer, House> getHouses() {
        return houses;
    }

    // 添加房屋信息
    public void addHouse(House house) {
        this.houses.put(++idCounter, house);
    }

    // 删除房屋信息
    public void deleteHouse(int id) {
        this.houses.remove(id);
    }



    
}
