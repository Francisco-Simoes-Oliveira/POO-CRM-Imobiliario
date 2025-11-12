package service;

import dao.CargoDao;
import modelo.Cargo;



public class CargoService extends ServiceImplementacao<CargoDao,Cargo, Long> {

    public CargoService() {
        super(CargoDao.class);
    }
}
