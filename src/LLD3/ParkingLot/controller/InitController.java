package LLD3.ParkingLot.controller;

import LLD3.ParkingLot.model.ParkingLot;
import LLD3.ParkingLot.service.InitService;

public class InitController {
    private InitService initService;

    public InitController(InitService initService) {
        this.initService = initService;
    }

    public ParkingLot init()
    {
        return initService.init();
    }
}
