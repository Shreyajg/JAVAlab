import java.util.Scanner;


class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}


class SonAgeException extends Exception {
    public SonAgeException(String message) {
        super(message);
    }
}


class NegativeSonAgeException extends Exception {
    public NegativeSonAgeException(String message) {
        super(message);
    }
}


class Father {
    private int age;
    
  
    public Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}


class Son extends Father {
    private int sonAge;

   
    public Son(int fatherAge, int sonAge) throws WrongAge, SonAgeException, NegativeSonAgeException {
        super(fatherAge);

        
        if (sonAge < 0) {
            throw new NegativeSonAgeException("Son's age cannot be negative");
        }
        
      
        if (sonAge >= fatherAge) {
            throw new SonAgeException("Son's age cannot be greater than or equal to father's age");
        }
        
        this.sonAge = sonAge;
    }

    public int getSonAge() {
        return sonAge;
    }
}

public class FatherSon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Father's Age: ");
            int fatherAge = sc.nextInt();
            System.out.print("Enter Son's Age: ");
            int sonAge = sc.nextInt();
            
            try {
                Son son = new Son(fatherAge, sonAge);  // Create Son object
                System.out.println("Accepted Successfully");
            } catch (WrongAge e) {
                System.out.println(e.getMessage());
            } catch (SonAgeException e) {
                System.out.println(e.getMessage());
            } catch (NegativeSonAgeException e) {
                System.out.println(e.getMessage());
            }

            // Ask if the user wants to re-enter details
            System.out.println("Would you like to re-enter details (Y/n)?");
            String input = sc.next();
            if (input.equalsIgnoreCase("n")) {
                break;
            }
        }
        sc.close();  
    }
}
