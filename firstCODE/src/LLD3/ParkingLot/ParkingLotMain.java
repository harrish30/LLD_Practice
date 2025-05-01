package LLD3.ParkingLot;

import LLD3.ParkingLot.controller.BillController;
import LLD3.ParkingLot.controller.InitController;
import LLD3.ParkingLot.controller.TicketController;
import LLD3.ParkingLot.model.*;
import LLD3.ParkingLot.model.enums.BillStatus;
import LLD3.ParkingLot.model.enums.PaymentMode;
import LLD3.ParkingLot.model.enums.PaymentStatus;
import LLD3.ParkingLot.model.enums.VehicleType;
import LLD3.ParkingLot.repository.*;
import LLD3.ParkingLot.service.BillService;
import LLD3.ParkingLot.service.InitialisationService;
import LLD3.ParkingLot.service.TicketService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ParkingLotMain
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        BillRepository billRepository = new BillRepository();
        InitialisationService initialisationService = new InitialisationService(
                parkingLotRepository,
                parkingFloorRepository,
                parkingSpotRepository,
                gateRepository);

        InitController initController = new InitController(initialisationService);
        TicketService ticketService = new TicketService(ticketRepository, parkingLotRepository, gateRepository, parkingSpotRepository);
        TicketController ticketController = new TicketController(ticketService);
        BillService billService = new BillService(billRepository, ticketRepository, parkingSpotRepository, gateRepository);
        BillController billController = new BillController(billService);

        System.out.println("***Parking lot data initialization start***");
        ParkingLot parkingLot = initController.init();
        System.out.println("***Parking lot data initialization end***");

        while(true)
        {
            System.out.println("Please enter an option -> 1. Enter the parking lot 2. Exit the parking lot 3. Exit");
            int option = scn.nextInt();

            if(option == 1)
            {
                Vehicle vehicle = new Vehicle();
                System.out.println("Welcome to our parking lot!");
                System.out.println("***Enter the vehicle details***");
                System.out.println("Enter the vehicle number: ");
                String vehicleNumber = scn.next();
                vehicle.setVehicleNumber(vehicleNumber);
                System.out.println("Choose the vehicle type -> 1. Car 2. Bike");
                int vehicleType = scn.nextInt();
                if(vehicleType == 1)
                {
                    vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
                }
                else if (vehicleType == 2)
                {
                    vehicle.setVehicleType(VehicleType.TWO_WHEELER);
                }
                System.out.println("Enter the vehicle color: ");
                String colour = scn.next();
                vehicle.setColour(colour);
                System.out.println("Please enter Parking Lot ID");
                int parkingLotId = scn.nextInt();
                System.out.println("Please enter gate ID");
                int gateId = scn.nextInt();
                Ticket ticket = ticketController.generateTicket(vehicle, gateId, parkingLotId);
                System.out.println("Ticket details: " + ticket);
            }
            else if (option == 2)
            {
                //ask user for ticketid and exit gate id
                System.out.println("Enter your Ticket ID: ");
                int ticketId = scn.nextInt();
                System.out.println("Enter your Exit Gate ID: ");
                int exitGateId = scn.nextInt();

                //call billcontroller
                Bill bill = billController.generateBill(ticketId, exitGateId);

                //print bill details
                System.out.println("Bill details: " + bill);

                //ask for payment method
                Payment payment = new Payment();
                System.out.println("Enter your preferred payment mode -> 1. Cash 2. UPI 3. Card");
                int paymentOption = scn.nextInt();
                if(paymentOption == 1)
                {
                    payment.setPaymentMode(PaymentMode.CASH);
                }
                else if(paymentOption == 2)
                {
                    payment.setPaymentMode(PaymentMode.UPI);
                }
                else if(paymentOption == 3)
                {
                    payment.setPaymentMode(PaymentMode.CARD);

                }
                payment.setAmount(bill.getAmount());
                payment.setBill(bill);
                payment.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESSFUL);
                payment.setPaymentTime(LocalDateTime.now());

                //mark the bill as paid
                bill.setBillStatus(BillStatus.BILL_PAID);
            }
            else
            {
                System.out.println("Thanks for parking here!");
                break;
            }
        }
    }
}
