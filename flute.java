package niv;

	import java.util.InputMismatchException;
	import java.util.Scanner;

	public class flute extends WindInstrument {
	    public static final String[] FLUET_TYPE= {"Flute", "Recorder","Bass"};

	    private String fluteType;


	    public flute(String brand, Number price, String material, String fluteType){
	        super(brand, price, material);
	        setFluteType(fluteType);
	    }

	    public flute(Scanner scanner){
	        super(scanner);
	        setFluteType(scanner.nextLine());
	    }

	    public String getFluteType() {
	        return fluteType;
	    }

	    public void setFluteType(String fluteType) {
	        if(!isFluteType(fluteType))
	            throw new InputMismatchException("Invalid flute type: "+ fluteType);

	        this.fluteType = fluteType;
	    }

	    private boolean isFluteType(String input){
	        return isValidType(FLUET_TYPE, input);
	    }

	    @Override
	    public boolean equals(Object o) {
	        if(!super.equals(o))
	            return false;

	        if(!(o instanceof flute))
	            return false;

	        return getFluteType().equals(((flute)o).getFluteType());
	    }

	    @Override
	    public String toString() {
	        return super.toString() + String.format(" Type: %7s", getFluteType().toString());
	    }


	
		@Override 
		public flute clone() throws CloneNotSupportedException{
			return (flute) super.clone();
	}

		}


