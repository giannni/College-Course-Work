
/**
 * Turn a zipcode into a barcode.
 * 
 * @author Gianni Esposito
 * @version v1
 */
public class PostalZipCode
{
    private String barCode;
    private String zipCode;

    
    public PostalZipCode()
    {
        barCode = "";
        zipCode = "";
    }

   
    public PostalZipCode(String barCode)
    {
        char numbers;
        this.barCode = barCode;
        this.zipCode = "";
        for(int i=0; i<barCode.length(); i ++)
        {
            numbers = barCode.charAt(i);
            this.zipCode += getBarCode(numbers);
        }
    }
    
    public int checkDigit(String zipCode)
    {
    	int total = 0;
    	int checkDigit = 0;
        for(int i=0; i<zipCode.length(); i++){
        	checkDigit = checkDigit + Character.getNumericValue(zipCode.charAt(i));
        }
        total = checkDigit;
        while (total % 10 != 0) {
            total++;
        }  
        int result = total - checkDigit;
        return result;
    }
    
    public String getBarCode(char numbers)
    {
        String code = "";
        switch(numbers)
        {
            case '0' : code = "||:::";
            break;
            case '1' : code = ":::||";
            break;
            case '2' : code = "::|:|";
            break;
            case '3' : code = "::||:";
            break;
            case '4' : code = ":|::|";
            break;
            case '5' : code = ":|:|:";
            break;
            case '6' : code = ":||::";
            break;
            case '7' : code = "|:::|";
            break;
            case '8' : code = "|::|:";
            break;
            case '9' : code = "|:|::";
            break;
        }
        return code;
    }
    
    public String getZipCode()
    {
        return zipCode;
    }
}
