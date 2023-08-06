package bus;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/21
 **/
public class NewEnergy extends Bus{

    public NewEnergy() {
    }

    /**
     * 构造方法初始化
     *
     * @param currentStation
     * @param basePrice
     */
    public NewEnergy(int currentStation, double basePrice) {
        super(currentStation, basePrice);
    }
}
