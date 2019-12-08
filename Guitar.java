package niv;

	
	import java.util.InputMismatchException;
	import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

	public class Guitar extends Stringinstrument {
		Alert alert = new Alert(AlertType.ERROR);

	    public static final String GUITAR_TYPE[] ={"Classic", "Acoustic",  "Electric"};

	    public static final int CLASSIC = 0, ACOUSTIC = 1,ELECTRIC = 2;
	    public static final int CLASSIC_NUM_OF_STRINGS = 6, ACOUSTIC_NUM_OF_STRINGS = 6,
	                            ELEC_MAX_NUM_OF_STRINGS = 8, ELEC_MIN_NUM_OF_STRINGS = 6;


	    private String type;

	    public static String[] getGuitarType() {
			return GUITAR_TYPE;
		}

		public Guitar(String brand, Number price, int numOfStrings, String type){
	        super(brand, price, numOfStrings);
	        this.type=type;
	    }

	    public Guitar(Scanner scanner){
	        super(scanner);
	        String type; 
	        scanner.nextLine();
	        type = scanner.nextLine();
	        setType(type);
	        int numOfStrings=getNumOfStrings();

	        switch (indexOfType()){
	            case CLASSIC:
	                if(numOfStrings != CLASSIC_NUM_OF_STRINGS) {
	                	alert.setTitle("Eror");
	        			alert.setHeaderText("Eror");
	        			alert.setContentText(" Classic Guitars have 6 String not "+ numOfStrings);
	        			alert.showAndWait();
	                break;
	                }

	            case ACOUSTIC:
	                if(numOfStrings != ACOUSTIC_NUM_OF_STRINGS)
	                    throw new InputMismatchException("Acoustic Guitars have 6 strings, not " + numOfStrings);
	                break;

	            case ELECTRIC:
	                if(numOfStrings < ELEC_MIN_NUM_OF_STRINGS  || numOfStrings > ELEC_MAX_NUM_OF_STRINGS)
	                    throw new InputMismatchException("Acoustic Guitars have 6 strings, not " + numOfStrings);
	                break;
	        }
	        
	    }

	    private boolean isGuitarType(String input){
	        return isValidType(GUITAR_TYPE, input);
	    }

	   private int indexOfType(){
	        for(int i = 0 ; i < GUITAR_TYPE.length; i++) {
	            if (getType().equals(GUITAR_TYPE[i])) {
	                return i;
	            }
	        }
	        return 0;
	    }
	    

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	    	int numOfStrings=getNumOfStrings();
	        if(isGuitarType(type))
	            this.type = type;
	        else
	            throw new InputMismatchException("Invalid guitar type: "+type);
	    
	    }


	    @Override
	    public void setNumOfStrings(int numOfStrings) {
	            super.setNumOfStrings(numOfStrings);
	    }


	    @Override
	    public String toString() {
	        return super.toString() + String.format(" Type: %7s", getType().toString());
	    }

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (!(obj instanceof Guitar))
				return false;
			Guitar other = (Guitar) obj;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}

		@Override 
		public Guitar clone() throws CloneNotSupportedException{
			return (Guitar) super.clone();
		}
	}


	



