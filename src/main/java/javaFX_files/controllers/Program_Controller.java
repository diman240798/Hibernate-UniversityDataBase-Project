package javaFX_files.controllers;

import Dao_Interfaces.DaoReasonGettingNobelPrze;
import Dao_Interfaces.DaoUniversity;
import Dao_Interfaces.DaoWhereScientistLearnt;
import Dao_Interfaces.DaoWhereScientistTought;
import Dao_Services.*;
import Tables.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Here I control my GUI Interface!
 */

public class Program_Controller implements Initializable {

    /**
     * First Tab (Scientist)
     */
    @FXML
    private TextField tfScnName;
    @FXML
    private TextField tfScnSurname;
    @FXML
    private TextField tfScnCountry;
    @FXML
    private TextField tfScnBirthDate;
    @FXML
    private TextField tfScnDeathDate;

    /**
     * Second Tab (University)
     */
    @FXML
    private TextField tfUnName;
    @FXML
    private TextField tfUnCountry;
    @FXML
    private TextField tfUnCity;

    /**
     * Third Tab (Where Scientist Learn)
     */
    @FXML
    private TextField tfLEARNscnID;
    @FXML
    private TextField tfLEARNunID;
    /**
     * Fourth Tab (Where Scientist Tought)
     */
    @FXML
    private TextField tfTOUGHTscnID;
    @FXML
    private TextField tfTOUGHTunID;

    /**
     * Fifth Tab (Reason Getting Nobel Prize)
     */
    @FXML
    private TextField tfREASONscnID;
    @FXML
    private TextField tfREASONfield;
    @FXML
    private TextField tfREASON;
    @FXML
    private TextField tfREASONDate;

    /**
     * Sixth Tab
     */
    @FXML
    private TextArea taHereInfo;

    /**
     * Dao classes
     */
    DaoScientist_Service daoScientist_service = new DaoScientist_Service();
    DaoUniversity daoUniversity_service = new DaoUniversity_Service();
    DaoWhereScientistLearnt daoWhereScientistLearnt_service = new DaoWhereScientistLearnt_Service();
    DaoWhereScientistTought daoWhereScientistTought_service = new DaoWhereScientistTought_Service();
    DaoReasonGettingNobelPrze daoReasonGettingNobelPrze_service = new DaoReasonGettingNobelPrze_Service();

    /**
     * First Tab
     * <p>
     * Here We Insert Scientist Into Table Scientist
     *
     * @param actionEvent,TestFields(tfScn)
     */


    public void AddScientist(ActionEvent actionEvent) {
           /*
              Create new Scientist
             */
        Scientist scientist = new Scientist();
        // Get Info From TeftFields
        scientist.setName(tfScnName.getText());
        scientist.setSurname(tfScnSurname.getText());
        scientist.setCountry(tfScnCountry.getText());
        scientist.setBirthDate(tfScnBirthDate.getText());
        scientist.setDeathDate(tfScnDeathDate.getText());
           /*
              Save Scientist
             */
        daoScientist_service.save(scientist);

    }

    /**
     * Print Information in TextArea (Tab Information)
     *
     * @param actionEvent
     */
    public void SCgetInfo(ActionEvent actionEvent) {
        taHereInfo.setText(daoScientist_service.printAll());
    }

    /**
     * Second Tab
     * <p>
     * Here We Insert University Into Table University
     *
     * @param actionEvent,TestFields(tfUn)
     */

    public void AddUniversity(ActionEvent actionEvent) {

        /**
         Create new University
         */

        University university = new University();
        /**
         Get Info From TeftFields
         */
        university.setName(tfUnName.getText());
        university.setCountry(tfUnCountry.getText());
        university.setCity(tfUnCity.getText());
        /**
         Save University
         */
        daoUniversity_service.save(university);
    }

    /**
     * Print Information in TextArea (Tab Information)
     *
     * @param actionEvent
     */
    public void UNgetInfo(ActionEvent actionEvent) {
        taHereInfo.setText(daoUniversity_service.printAll());
    }

    /**
     * Third Tab
     * <p>
     * Here We Insert Scientist and University Into Table WhereScientistLearnt
     *
     * @param actionEvent,TestFields(tfLEARN)
     */

    public void AddWhereScientisLearn(ActionEvent actionEvent) {
        /**
         * Create new Note
         */
        WhereScientistLearnt whereScientistLearnt = new WhereScientistLearnt();
        /**
         * Save WhereScientistLearnt
         */
        daoWhereScientistLearnt_service.save(whereScientistLearnt, tfLEARNscnID.getText(), tfLEARNunID.getText());
    }

    public void WSLgetInfo(ActionEvent actionEvent) {

        taHereInfo.setText(daoWhereScientistLearnt_service.printAll());
    }

    /**
     * Fourth Tab
     * <p>
     * Here We Insert Scientist and University Into Table WhereScientistTought
     *
     * @param actionEvent,TestFields(tfTought)
     */
    public void AddWhereScientistTought(ActionEvent actionEvent) {

        /**
         * Create new Note
         */
        WhereScientistTought whereScientistTought = new WhereScientistTought();

        // Save
        daoWhereScientistTought_service.save(whereScientistTought, tfTOUGHTscnID.getText(), tfTOUGHTunID.getText());

    }

    public void WSTgetInfo(ActionEvent actionEvent) {
        taHereInfo.setText(daoWhereScientistTought_service.printAll());

    }

    /**
     * Fifth Tab
     * <p>
     * Here We Insert Scientist and Info  Into Table ReasonGettingNobelPrize
     *
     * @param actionEvent,TestFields(tfREASON)
     */
    public void AddReasonGettingNobelPrize(ActionEvent actionEvent) {
        /**
         * Create new Note
         */
        ReasonGettingNobelPrz reasonGettingNobelPrz = new ReasonGettingNobelPrz();
        // Add Info
        reasonGettingNobelPrz.setField(tfREASONfield.getText());
        reasonGettingNobelPrz.setReason(tfREASON.getText());
        reasonGettingNobelPrz.setDate(tfREASONDate.getText());
        // Save
        daoReasonGettingNobelPrze_service.save(reasonGettingNobelPrz, tfREASONscnID.getText());

    }

    public void RGNPgetInfo(ActionEvent actionEvent) {
        taHereInfo.setText(daoReasonGettingNobelPrze_service.printAll());

    }


    // Program Localization

    private ResourceBundle resourceBundle;

    /**
     * ChoiceBox chooseLanguage
     */
    @FXML
    public ChoiceBox chooseLanguage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
    }


    public void ChangeLanguage(ActionEvent actionEvent) {
        loadLang(chooseLanguage.getValue().toString());
    }


    private void loadLang(String lang) {
        // Check that lang is not empty
        if (lang.isEmpty())
            return;

        // Create Localization
        Locale locale = new Locale(lang);
        // Get needed Bundle
        resourceBundle = ResourceBundle.getBundle("bundles.Locale", locale);

        // Fill Scientist Activity
        LBnameSCN.setText(resourceBundle.getString("Text_Name"));
        LBsurnameSCN.setText(resourceBundle.getString("Text_surname"));
        LBcountrySCN.setText(resourceBundle.getString("Text_Country"));
        LBBirthDateSCN.setText(resourceBundle.getString("Text_BirthDate"));
        LBdeathDateSCN.setText(resourceBundle.getString("Text_DeathDate"));
        BTNaddScientist.setText(resourceBundle.getString("Text_AddSCN"));
        BTNinfoSCN.setText(resourceBundle.getString("Text_Info"));

        // Fill University Activity
        LBnameUNIV.setText(resourceBundle.getString("Text_Name"));
        LBcountryUNIV.setText(resourceBundle.getString("Text_Country"));
        LBcityUNIV.setText(resourceBundle.getString("Text_City"));
        BTNaddUNIV.setText(resourceBundle.getString("Text_AddUNIV"));
        BTNinfoUNIV.setText(resourceBundle.getString("Text_Info"));

        // Fill Study Activity
        LBscnIDstudy.setText(resourceBundle.getString("Text_SCNid"));
        LBunIDstudy.setText(resourceBundle.getString("Text_UNIVid"));
        BTNaddStudy.setText(resourceBundle.getString("Text_AddInfo"));
        BTNinfoStudy.setText(resourceBundle.getString("Text_Info"));

        // Fill Teach Activity
        BTNinfoteach.setText(resourceBundle.getString("Text_SCNid"));
        LBscnIDteach.setText(resourceBundle.getString("Text_UNIVid"));
        BTNaddTeach.setText(resourceBundle.getString("Text_AddInfo"));
        BTNinfoTeach.setText(resourceBundle.getString("Text_Info"));

        // Fill Scientist Activity
        LBnameSCN.setText(resourceBundle.getString("Text_Name"));
        LBsurnameSCN.setText(resourceBundle.getString("Text_surname"));
        LBcountrySCN.setText(resourceBundle.getString("Text_Country"));
        LBBirthDateSCN.setText(resourceBundle.getString("Text_BirthDate"));
        LBdeathDateSCN.setText(resourceBundle.getString("Text_DeathDate"));
        BTNaddScientist.setText(resourceBundle.getString("Text_AddSCN"));
        BTNinfoSCN.setText(resourceBundle.getString("Text_Info"));

        // Fill NobelPrizeWinner Activity
        LBscientistID.setText(resourceBundle.getString("Text_SCNid"));
        LBfield.setText(resourceBundle.getString("Text_Field"));
        LBreason.setText(resourceBundle.getString("Text_Reason"));
        LBdate.setText(resourceBundle.getString("Text_Date"));
        BTNaddNBL.setText(resourceBundle.getString("Text_AddInfo"));
        BTNinfoNBL.setText(resourceBundle.getString("Text_Info"));


    }

    // Labels for localization

    // Scientist Activity
    @FXML
    private Label LBnameSCN;
    @FXML
    private Label LBsurnameSCN;
    @FXML
    private Label LBcountrySCN;
    @FXML
    private Label LBBirthDateSCN;
    @FXML
    private Label LBdeathDateSCN;
    @FXML
    private Button BTNaddScientist;
    @FXML
    private Button BTNinfoSCN;

    // University Activity
    @FXML
    private Label LBnameUNIV;
    @FXML
    private Label LBcountryUNIV;
    @FXML
    private Label LBcityUNIV;
    @FXML
    private Button BTNaddUNIV;
    @FXML
    private Button BTNinfoUNIV;

    // Study Activity
    @FXML
    private Label LBunIDstudy;
    @FXML
    private Label LBscnIDstudy;
    @FXML
    private Button BTNaddStudy;
    @FXML
    private Button BTNinfoStudy;

    // Teach Activity
    @FXML
    private Label BTNinfoteach;
    @FXML
    private Label LBscnIDteach;
    @FXML
    private Button BTNaddTeach;
    @FXML
    private Button BTNinfoTeach;

    // NobelPrizeWinner Activity
    @FXML
    private Label LBscientistID;
    @FXML
    private Label LBfield;
    @FXML
    private Label LBreason;
    @FXML
    private Label LBdate;
    @FXML
    private Button BTNaddNBL;
    @FXML
    private Button BTNinfoNBL;

}
