package ExerciseProject.HouseRent;

// 将所有房屋信息提取成一个类，信息就是属性
// 里面包括有 房主 电话 地址 月租 状态(出租/未出租) 等信息
public class House {
    private String name;
    private String phone;
    private String address;
    private double rend;
    private String state;

    public House(String name, String phone, String address, double rend, String state) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rend = rend;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%-6s%-10s%-6s%-10s%-6s", name, phone, address, rend+"", state);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRend() {
        return rend;
    }

    public void setRend(double rend) {
        this.rend = rend;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    


}
