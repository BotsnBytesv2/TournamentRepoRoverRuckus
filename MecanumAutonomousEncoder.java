package org.firstinspires.ftc.v1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

@Autonomous(name = "MecanumAutonomousEncoder1", group = "V1 Concept")

public class MecanumAutonomousEncoder  extends LinearOpMode{
    
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontright = null;
    private DcMotor frontleft = null;
    private DcMotor backleft = null;
    private DcMotor backright = null;
    
    
    @Override
    public void runOpMode(){
        frontleft = hardwareMap.get(DcMotor.class, "frontleftmotor");
        frontright = hardwareMap.get(DcMotor.class, "frontrightmotor");
        backright = hardwareMap.get(DcMotor.class, "backrightmotor");
        backleft = hardwareMap.get(DcMotor.class, "backleftmotor");
        
       frontright.setDirection(DcMotor.Direction.FORWARD);
       frontleft.setDirection(DcMotor.Direction.REVERSE);
       backright.setDirection(DcMotor.Direction.FORWARD);
       backleft.setDirection(DcMotor.Direction.REVERSE);
    /*
        frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    */    
        frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        
        waitForStart();
        frontleft.setPower(0.0);
        frontright.setPower(0.0);
        backleft.setPower(0.0);
        backright.setPower(0.0);

        if (opModeIsActive()) {
        
        //telemetry.addLine("HI");
        int one_rotation=180;
        int plus_1_rotation=1120;
        moveForward(2498, 0.1);
        moveBackward(1064, 0.1);
        spinLeft(2240,0.1);
        moveForward(3830,0.1);
        spinRight(3360,0.1);
        moveBackward(1691,0.1);
        //moveRight(2*plus_1_rotation, 0.4);
        //1 180
        // 2 1120
        //
        //telemetry.addLine("HI");
        //stopMotors();
        
        }
        
    }
    
    //distance should be in ticks
    //1120 ticks per rotation
    public void moveForward(int distance, double power){
        frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        //int newtargetfl = frontleft.getTargetPosition() + (int)distance;
        //int newtargetfr = frontright.getTargetPosition() + (int)distance;
        //int newtargetbl = backleft.getTargetPosition() + (int)distance;
        //int newtargetbr = backright.getTargetPosition() + (int)distance;
        telemetry.addData("The distance is:",distance);
        
        telemetry.addData("The current position is:",frontleft.getCurrentPosition());
        
        frontleft.setTargetPosition(distance);
        frontright.setTargetPosition(distance);
        backleft.setTargetPosition(distance);
        backright.setTargetPosition(distance);
        
        
       

        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        telemetry.addData("time1:", runtime.seconds());
        
        frontleft.setPower(power);
       frontright.setPower(power);
       backleft.setPower(power);
       backright.setPower(power);
        telemetry.addData("time: 2",  runtime.seconds());
       
        telemetry.update();
        int i=0;
        
         while(opModeIsActive() && (-frontleft.getCurrentPosition())< distance ){
            
          // opModeIsActive() && frontleft.isBusy() && frontright.isBusy() && backleft.isBusy() && backright.isBusy()){
       // telemetry.addData("The Target is:",frontleft.getTargetPosition());
        telemetry.addData("The current position is:",(-frontleft.getCurrentPosition()));
       
        telemetry.addData("The current position is:",(-frontleft.getCurrentPosition()/1120));
        telemetry.addData("The  position reminder:",(-frontleft.getCurrentPosition()%1120));
        telemetry.addData("The set position is:",frontleft.isBusy());
        telemetry.addData("The set position is:",i++);
        
        
        }
        
        telemetry.update();
        stopMotors();
        
       
    }
    public void moveBackward(int distance, double power){
        frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        frontleft.setTargetPosition(-distance);
        frontright.setTargetPosition(-distance);
        backleft.setTargetPosition(-distance);
        backright.setTargetPosition(-distance);

        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontleft.setPower(-power);
        frontright.setPower(-power);
        backleft.setPower(-power);
        backright.setPower(-power);
        
        while((frontleft.getCurrentPosition())< distance){
            
          // opModeIsActive() && frontleft.isBusy() && frontright.isBusy() && backleft.isBusy() && backright.isBusy()){
       // telemetry.addData("The Target is:",frontleft.getTargetPosition());
        telemetry.addData("The current position is:",(-frontleft.getCurrentPosition()));
       
        telemetry.addData("The current position is:",(-frontleft.getCurrentPosition()/1120));
        telemetry.addData("The  position reminder:",(-frontleft.getCurrentPosition()%1120));
        telemetry.addData("The set position is:",frontleft.isBusy());
        //telemetry.addData("The set position is:",i++);
        
        
        }
    stopMotors();
    }
    public void moveRight(int distance, double power){
        frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        frontleft.setTargetPosition(distance);
        frontright.setTargetPosition(-distance);
        backleft.setTargetPosition(-distance);
        backright.setTargetPosition(distance);

        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontleft.setPower(power);
        frontright.setPower(-power);
        backleft.setPower(-power-0.3);
        backright.setPower(power+0.3);
        
         while(opModeIsActive() && (-frontleft.getCurrentPosition())< distance ){
            
          // opModeIsActive() && frontleft.isBusy() && frontright.isBusy() && backleft.isBusy() && backright.isBusy()){
       // telemetry.addData("The Target is:",frontleft.getTargetPosition());
        telemetry.addData("The current position is:",(-frontleft.getCurrentPosition()));
       
        telemetry.addData("The current position is:",(-frontleft.getCurrentPosition()/1120));
        telemetry.addData("The  position reminder:",(-frontleft.getCurrentPosition()%1120));
        telemetry.addData("The set position is:",frontleft.isBusy());
        //telemetry.addData("The set position is:",i++);
        
        
        }
        stopMotors();

    }
    public void moveLeft(int distance, double power){
        frontleft.setMode(DcMotor.RunMode.RESET_ENCODERS);
        frontright.setMode(DcMotor.RunMode.RESET_ENCODERS);
        backleft.setMode(DcMotor.RunMode.RESET_ENCODERS);
        backright.setMode(DcMotor.RunMode.RESET_ENCODERS);
        
        frontleft.setTargetPosition(-distance);
        frontright.setTargetPosition(distance);
        backleft.setTargetPosition(distance);
        backright.setTargetPosition(-distance);

        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontleft.setPower(-power);
        frontright.setPower(power);
        backleft.setPower(power);
        backright.setPower(-power);
        
         while(opModeIsActive() && (frontleft.getCurrentPosition())< distance){
        
    }
        stopMotors();
        
    }
    public void spinRight(int distance, double power){
        frontleft.setMode(DcMotor.RunMode.RESET_ENCODERS);
        frontright.setMode(DcMotor.RunMode.RESET_ENCODERS);
        backleft.setMode(DcMotor.RunMode.RESET_ENCODERS);
        backright.setMode(DcMotor.RunMode.RESET_ENCODERS);
        
        frontleft.setTargetPosition(-distance);
        frontright.setTargetPosition(distance);
        backleft.setTargetPosition(-distance);
        backright.setTargetPosition(distance);

        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontleft.setPower(-power);
        frontright.setPower(power);
        backleft.setPower(-power);
        backright.setPower(power);
        
         while(opModeIsActive() && (frontleft.getCurrentPosition())< distance){
        
    }
        stopMotors();
    }
    public void spinLeft(int distance, double power){
        frontleft.setMode(DcMotor.RunMode.RESET_ENCODERS);
        frontright.setMode(DcMotor.RunMode.RESET_ENCODERS);
        backleft.setMode(DcMotor.RunMode.RESET_ENCODERS);
        backright.setMode(DcMotor.RunMode.RESET_ENCODERS);
        
        frontleft.setTargetPosition(distance);
        frontright.setTargetPosition(-distance);
        backleft.setTargetPosition(distance);
        backright.setTargetPosition(-distance);

        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontleft.setPower(power);
        frontright.setPower(-power);
        backleft.setPower(power);
        backright.setPower(-power);
        
         while(opModeIsActive() && (-frontleft.getCurrentPosition())< distance){
        
    }
        stopMotors();
        
    }
    public void stopMotors(){
        frontleft.setPower(0.0);
        frontright.setPower(0.0);
        backleft.setPower(0.0);
        backright.setPower(0.0);
        sleep(800);
        frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}

