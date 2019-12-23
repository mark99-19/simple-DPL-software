package primo;

import secondo.Privilege_Escalation;
import secondo.Starter;

public class Eccezione_privilegeEsc extends Exception{
	Privilege_Escalation PrEsc = new Privilege_Escalation(Starter.disessione);
}
    