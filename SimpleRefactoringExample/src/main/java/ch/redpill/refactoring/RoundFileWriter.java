package ch.redpill.refactoring;
public class RoundFileWriter {
	private Round[] roundsTable;
	private int _count;

	public RoundFileWriter(Round[] roundsTable) {
		this.roundsTable = roundsTable;
	}

	/*
	 * Write Magazine File
	 * Iterates through round, customer and parcel tables to print file contents
	 * in the format:
	 * ROUND_NAME_1
	 * CUSTOMER_NAME_1
	 * PARCEL_1
	 * PARCEL_2
	 * CUSTOMER_NAME_2
	 * ROUND_NAME_2
	 * etc.
	 */
	public String writeMagazineFile() {
		// Create empty fBuf string
		String fBuf = "";
		System.out.print(fBuf);
		int rCount = -1;
		
		// Append parcel barcodes for each round
		for (int r=0; r<roundsTable.length; ++r) {
			rCount = 0;
			if (hasParcels(roundsTable[r])) {

				// Get round names for this round
				Customer[] pNames = roundsTable[r].getNames();
				
				// Append barcodes for each customer
				for (int i = 0; i < pNames.length; i++) {
					Customer pName = pNames[i];
					Parcel[] barcode = roundsTable[r].getNames()[i].getMagazines();
					
				// Append each barcode
				for (int j = 0; j < barcode.length; j++) {
				    
					// If parcel is magazine then add it to file
					if (barcode[j].getType() == true) {
						String n = roundsTable[r].getName();
						fBuf += n + ",";
						rCount++;
						fBuf += pName.getName() + ",";
						fBuf += barcode[j].getCode() + "\n";
						}
					}
				}
			}
		}
		_count = rCount;
		return fBuf;
	}

	/*
	 * Write Magazine File
	 * Iterates through round, customer and parcel tables to print file contents
	 * in the format:
	 * ROUND_NAME_1
	 * CUSTOMER_NAME_1
	 * PARCEL_1
	 * PARCEL_2
	 * CUSTOMER_NAME_2
	 * ROUND_NAME_2
	 * etc.
	 */
	public String writeNewspaperFile() {
		// Create empty fBuf string
		String fBuf = "";
		
		// Append parcel barcodes for each round
		for (int r=0; r<roundsTable.length; ++r) {
			if (hasParcels(roundsTable[r])) {

				// Get round names for this round
				Customer[] pNames = roundsTable[r].getNames();
				
				// Append barcodes for each customer
				for (int i = 0; i < pNames.length; i++) {
					Customer pName = pNames[i];
					Parcel[] barcode = roundsTable[r].getNames()[i].getMagazines();
					
					// Append each barcode
					for (int j = 0; j < barcode.length; j++) {
					    
						// If parcel is magazine then add it to file
						if (barcode[j].getType() != true) {
							fBuf += roundsTable[r].getName() + ",";
							fBuf += pName.getName() + ",";
							fBuf += barcode[j].getCode() + "\n";
						}
					}
				}
			}
		}
		return fBuf;
	}

	public boolean hasParcels(Round roundName) {
		Customer[] customerNames = (Customer[]) roundName.getNames();
		if(customerNames.length == 0){
			return false;
		}
		for (int i = 0; i < customerNames.length; i++) {
			Customer customerName = customerNames[i];
			Parcel[] parcelBarcodes = ((Customer) roundName.getNames()[i]).getMagazines();
			if(parcelBarcodes.length != 0){
				return true;
			}
		}
		return false;
	}
	
	public int numberOfParcels(String customerName){
	    Customer customer = null;
	    for (int i = 0; i < roundsTable.length; i++) {
            for (int j = 0; j < roundsTable[i].getNames().length; j++) {
                if (roundsTable[i].getNames()[j].getName() == customerName) {
                    customer = roundsTable[i].getNames()[j];
                    break;
                }                    
            }
        }
		Parcel[] parcelBarcodes = (Parcel[]) customer.getMagazines();
		int count = 0;
		for (int i = 0; i < parcelBarcodes.length; i++) {
			count++;
		}
		return count;
	}
}