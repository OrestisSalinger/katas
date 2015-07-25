package eu.salingers.refactoring;
public class RouteFileWriter {
	private Route[] routesTable;
	private int _count;

	public RouteFileWriter(Route[] routesTable) {
		this.routesTable = routesTable;
	}

	/*
	 * Write Magazine File
	 * Iterates through route, purchaser and order tables to print file contents
	 * in the format:
	 * ROUTE_NAME_1
	 * PURCHASER_NAME_1
	 * ORDER_1
	 * ORDER_2
	 * PURCHASER_NAME_2
	 * ROUTE_NAME_2
	 * etc.
	 */
	public String writePizzaFile() {
		// Create empty fBuf string
		String fBuf = "";
		System.out.print(fBuf);
		int rCount = -1;
		
		// Append parcel barcodes for each round
		for (int r=0; r<routesTable.length; ++r) {
			rCount = 0;
			if (hasOrder(routesTable[r])) {

				// Get round names for this round
				Purchaser[] pNames = routesTable[r].getNames();
				
				// Append barcodes for each customer
				for (int i = 0; i < pNames.length; i++) {
					Purchaser pName = pNames[i];
					Order[] barcode = routesTable[r].getNames()[i].getMagazines();
					
				// Append each barcode
				for (int j = 0; j < barcode.length; j++) {
				    
					// If parcel is magazine then add it to file
					if (barcode[j].getType() == true) {
						String n = routesTable[r].getName();
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
		System.out.println("Pizza File:\n" + fBuf);
		return fBuf;
	}

	/*
	 * Write Magazine File
	 * Iterates through Iterates through route, purchaser and order tables to print file contents
	 * in the format:
	 * ROUTE_NAME_1
	 * PURCHASER_NAME_1
	 * ORDER_1
	 * ORDER_2
	 * PURCHASER_NAME_2
	 * ROUTE_NAME_2
	 * etc.
	 */
	public String writeKebapFile() {
		// Create empty fBuf string
		String fBuf = "";
		
		// Append parcel barcodes for each round
		for (int r=0; r<routesTable.length; ++r) {
			if (hasOrder(routesTable[r])) {

				// Get round names for this round
				Purchaser[] pNames = routesTable[r].getNames();
				
				// Append barcodes for each customer
				for (int i = 0; i < pNames.length; i++) {
					Purchaser pName = pNames[i];
					Order[] barcode = routesTable[r].getNames()[i].getMagazines();
					
					// Append each barcode
					for (int j = 0; j < barcode.length; j++) {
					    
						// If parcel is magazine then add it to file
						if (barcode[j].getType() != true) {
							fBuf += routesTable[r].getName() + ",";
							fBuf += pName.getName() + ",";
							fBuf += barcode[j].getCode() + "\n";
						}
					}
				}
			}
		}
		System.out.println("Kebap File\n" + fBuf);
		return fBuf;
	}

	public boolean hasOrder(Route routeName) {
		Purchaser[] customerNames = (Purchaser[]) routeName.getNames();
		if(customerNames.length == 0){
			return false;
		}
		for (int i = 0; i < customerNames.length; i++) {
			Purchaser customerName = customerNames[i];
			Order[] parcelBarcodes = ((Purchaser) routeName.getNames()[i]).getMagazines();
			if(parcelBarcodes.length != 0){
				return true;
			}
		}
		return false;
	}
	
	public int numberOfOrders(String customerName){
	    Purchaser customer = null;
	    for (int i = 0; i < routesTable.length; i++) {
            for (int j = 0; j < routesTable[i].getNames().length; j++) {
                if (routesTable[i].getNames()[j].getName() == customerName) {
                    customer = routesTable[i].getNames()[j];
                    break;
                }                    
            }
        }
		Order[] orderBarcodes = (Order[]) customer.getMagazines();
		int count = 0;
		for (int i = 0; i < orderBarcodes.length; i++) {
			count++;
		}
		return count;
	}
}