package Bean;

public class Toyota extends ToyotaEngine {
	public void move() {
		// Toyota要能夠移動，必須要有可以啟動的引擎
		// 1. 創建物件
		ToyotaEngine toyotaEngine = new ToyotaEngine();
		toyotaEngine.start();

		// 2. 從引擎繼承的 start 方法
		// start();

		// 若 ToyotaEngine 有變化，Toyota 也需要跟著修正
	}
}
