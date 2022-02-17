public class Main {
    /**
     * 费用: 
     * 儿童片 前3天一共1.5 超过3天每天1.5
     * 新片 每天3元
     * 普通片 前两天 一共2元, 2天后每天1.5
     */

    /**
     * 积分: 新片且大于一天租赁  2个积分, 其他片每部一积分
     */
    public static void main(String[] args) {
        Movie movie = new Movie("猫和老鼠", 2);
        Rental rental = new Rental(movie, 7);

        Movie movie1 = new Movie("功夫", 0);
        Rental rental1 = new Rental(movie1, 3);

        Movie movie2 = new Movie("水门桥", 1);
        Rental rental2 = new Rental(movie2, 2);

        Customer customer = new Customer("齐秦");
        customer.addRental(rental);
        customer.addRental(rental1);
        customer.addRental(rental2);
        System.out.println(customer.statement());
    }
}

/**
 * 重构
 * 单元测试: 重构的第一步, 写好用例后, 会反复对修改的代码进行测试
 * 提取方法: 降低复杂度, 更轻松的修改和移动,  防止代码产生重复 
 * 移动方法: 移动到合适的类下(领域)
 * 重命名符号: 更加语义化, 提高代码的清晰度
 * 消除局部变量: 局部变量会被滥用进行传递, 很多时候根本不需要
 * 消除额外参数: 返回值在外部进行累加,减少了方法多余的传参, 方法内聚处理并返回
 * 方法委托: 常见重构后, 保持调用方稳定不修改, 将新方法在原api上进行调用
 * switch的方法应该移动至与对应属性的类, 如果两个对象都可以放置方法, 一定要考虑移动至具有变化和不稳定倾向的类, 另一个不会被影响, 同时, 有变化时, 在一个类中就可以完成处理
 * 类上可以定义一些常量, 方便逻辑中判断
 * 消除switch: 使用类继承 与 多态的机制
 * 总结: 通过不断的封装, 提取, 移动等重构方法, 代码越来越清晰, 并且不再耦合, 每层的调用链非常薄, 在movie类和价格频繁变化时, 依赖他们的类完全无感知, 维护性非常高
 */
