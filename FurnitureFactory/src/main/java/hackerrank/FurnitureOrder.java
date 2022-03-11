package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
	private final HashMap<Furniture, Integer> furn;
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
	furn = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
	Integer c = 0;
	if(furn.containsKey(type)){
		c = furn.get(type);
	}
	furn.put(type, c + furnitureCount);

    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return new HashMap<Furniture, Integer>(furn);
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
	if(!furn.isEmpty()){
		return furn.entrySet().stream().map(f -> f.getKey().cost() * f.getValue()).collect(Collectors.toList()).stream().reduce(Float :: sum).get();
	}	
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
	if(furn.containsKey(type)){
		return furn.get(type);
	}
        return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
	if(furn.containsKey(type)){
		return furn.get(type) * type.cost();
	}
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
	if(!furn.isEmpty()){
		return furn.values().stream().reduce(Integer :: sum).get();
	}
        return 0;
    }
}
