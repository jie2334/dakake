package bus;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/21
 **/
public class Tram extends Bus{
    public Tram() {
    }

    /**
     * 构造方法初始化
     *
     * @param currentStation
     * @param basePrice
     */
    public Tram(int currentStation, double basePrice) {
        super(currentStation, basePrice);
    }
}
