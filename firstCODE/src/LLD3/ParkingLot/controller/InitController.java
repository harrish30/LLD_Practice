package LLD3.ParkingLot.controller;

import LLD3.ParkingLot.model.ParkingLot;
import LLD3.ParkingLot.service.InitialisationService;

public class InitController {
    private InitialisationService initialisationService;

    public InitController(InitialisationService initialisationService) {
        this.initialisationService = initialisationService;
    }

    public ParkingLot init()
    {
        return initialisationService.init();
    }
}
