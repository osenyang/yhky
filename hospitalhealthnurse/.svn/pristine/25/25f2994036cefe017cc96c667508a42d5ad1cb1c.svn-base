package com.elink.hospitalhealthnurse.modules.healtharchives.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.elink.hospitalhealthnurse.common.persistence.BaseEntity;
import com.elink.hospitalhealthnurse.common.utils.IdGen;

/**
 * 健康记录Entity
 * @author 颜福艳
 * @version 2016-11-01
 */
@Entity
@Table(name = "hn_health_record")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HealthRecord extends BaseEntity<HealthRecord> {
	
	private static final long serialVersionUID = 1L;

	public HealthRecord() {
		super();
	}

	public HealthRecord(String id){
		this();
		this.id = id;
	}
	
	@PrePersist
	public void prePersist(){
		this.id = IdGen.uuid();
		this.createDate = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	private String id;	//编号
   
	private String userId; //老人id    
   
	private String province; //省    
   
	private String city; //市    
   
	private String area; //区    
   
	private String address; //详细地址    
   
	private String maritalStatus; //婚姻状况    
   
	private String nation; //民族    
   
	private String relator; //健康状况陈述者    
   
	private String relation; //与入住者关系    
   
	private java.util.Date arrivalDate; //入住日期    
   
	private String arrivalReason; //入住原因    
   
	private String emotion; //一般情况 情绪    
   
	private String somnus; //睡眠    
   
	private String spirit; //精神    
   
	private String orexia; //食欲    
   
	private String habitsCustoms; //生活习惯    
   
	private String shit; //大便    
   
	private Integer looseStoolsNumber; //便溏次数    
   
	private Integer looseStoolsDays; //便溏天数    
   
	private String lifeSelfAbility; //生活自理能力    
   
	private String pee; //小便    
   
	private String healthCondition; //平常健康情况    
   
	private String diseaseNm1; //病名    
   
	private Integer diseaseYear1; //患病年数    
   
	private String diagnosedHospital1; //确诊医院    
   
	private String diseaseNm2; //病名    
   
	private Integer diseaseYear2; //患病年数    
   
	private String diagnosedHospital2; //确诊医院    
   
	private String diseaseNm3; //病名    
   
	private Integer diseaseYear3; //患病年数    
   
	private String diagnosedHospital3; //确诊医院    
   
	private String diseaseNm4; //病名    
   
	private Integer diseaseYear4; //患病年数    
   
	private String diagnosedHospital4; //确诊医院    
   
	private String diseaseNm5; //病名    
   
	private Integer diseaseYear5; //患病年数    
   
	private String diagnosedHospital5; //确诊医院    
   
	private String infectionHistory; //传染病史    
   
	private String bloodHistory; //输血史    
   
	private String allergyHistory; //药物过敏史    
   
	private String anaphylactogen; //过敏源    
   
	private String allergyClinicalManifestation; //过敏后临床表现    
   
	private String vaccinationHistory; //预防接种史    
   
	private String localLesionHistory; //局部病灶史    
   
	private String traumaSurgeryHistory; //外伤手术史    
   
	private String respiratorySystem; //呼吸系统    
   
	private String circulatorySystem; //循环系统    
   
	private String alimentarySystem; //消化系统    
   
	private String urogenitalSystem; //泌尿生殖系统    
   
	private String bloodSystem; //血液系统    
   
	private String endocrineMetabolicSystem; //内分泌与代谢系统    
   
	private String nervousSystem; //神经系统    
   
	private String movingSkeletalSystem; //运动骨骼系统    
	
	private String temperature; //体温(T)    
	   
	private String pulse; //脉搏(P)    
   
	private String breathingRate; //呼吸频率(R)    
   
	private String bloodPressure; //血压(Bp)    
   
	private String auxe; //发育    
   
	private String face; //面容    
   
	private String position; //体位    
   
	private String consciousness; //神志    
   
	private String nutrition; //营养    
   
	private String expression; //表情    
   
	private String gait; //步态    
   
	private String cooperateInspect; //配合检查    
   
	private String pigment; //色素    
   
	private String erythra; //皮疹    
   
	private String erythraType; //皮疹-类型及分布    
   
	private String subcutaneousHemorrhage; //皮下出血    
   
	private String subcutaneousHemorrhageType; //皮下出血-类型及分布    
   
	private String hairDistribution; //毛发分布    
   
	private String hairDistributionPosition; //毛发分布-部位    
   
	private String edema; //水肿    
   
	private String edemaPosition; //水肿-部位及程度    
   
	private String spider; //蜘蛛痣    
   
	private String spiderPosition; //蜘蛛痣-数目及部位    
   
	private String liverPalms; //肝掌    
   
	private String temperatureHumidity; //温度与湿度    
   
	private String elastic; //弹性    
   
	private String superficialLymphNodes; //全身浅表淋巴结    
   
	private String superficialLymphNodesPosition; //全身浅表淋巴结-部位及特征    
   
	private String head; //头部 头颅    
   
	private String malformation; //畸形    
   
	private String headTenderness; //压痛    
   
	private String headEnclosedMass; //包块    
   
	private String concaveLimit; //凹限    
   
	private String eyelid; //眼 眼脸    
   
	private String conjunctiva; //结膜    
   
	private String eyeball; //眼球    
   
	private String albugineaOculi; //巩膜    
   
	private String cerato; //角膜    
   
	private String pupil; //瞳孔    
   
	private String lightReaction; //对光反射    
   
	private String auricle; //耳 耳廓    
   
	private String externalSecretion; //外耳道分泌物    
   
	private String externalSecretionNature; //外耳道分泌物-性质    
   
	private String sternocleidomastoidPain; //乳突压痛    
   
	private String coarseHearingImpairment; //粗听力障碍    
   
	private String noseContour; //鼻 外形    
   
	private String otherAnomalies; //其他异常    
   
	private String nasalSinusTenderness; //鼻旁窦压痛    
   
	private String lip; //口唇 嘴唇    
   
	private String mucousCoat; //粘膜    
   
	private String parotidDuctOpening; //腮腺导管开口    
   
	private String tongue; //舌    
   
	private String gingiva; //齿龈    
   
	private String dentition; //齿列    
   
	private String agomphosisNumber; //缺牙颗数    
   
	private String tonsilla; //扁桃体    
   
	private String tonsillaFester; //扁桃体-化脓    
   
	private String pharynx; //咽    
   
	private String voice; //声音    
   
	private String senseResistance; //颈部 抵抗感    
   
	private String stiffnessArteryFluctuation; //劲动脉波动    
   
	private String jugularVein; //颈静脉    
   
	private String trachea; //气管    
   
	private String hepatojugularReflux; //肝颈静脉回流征    
   
	private String thyroid; //甲状腺    
   
	private String thyroidTumefaction; //甲状腺肿大-度    
   
	private String leftRightSidesMainly; //左右侧为主    
   
	private String thorax; //胸部 视诊 胸廓    
   
	private String breast; //乳房    
   
	private String breastEnclosedMass; //包块    
   
	private String breastTenderness; //压痛    
   
	private String excreta; //分泌物    
   
	private String respiratoryMovement; //呼吸运动    
   
	private String ribSpace; //肋间隙    
   
	private String ribSpacePosition; //肋间隙-部位    
   
	private String vocalFremitus; //语颤    
   
	private String pleuralFriction; //胸膜摩擦感    
   
	private String pleuralFrictionPosition; //胸膜摩擦感-部位    
   
	private String subcutaneousCrepitus; //皮下捻发感    
   
	private String subcutaneousCrepitusPosition; //皮下捻发感-部位    
   
	private String percussBucklePain; //叩诊 扣痛    
   
	private String scapularLineLeft; //肺下界 肩甲线左 肋间隙    
   
	private String scapularLineRight; //右 肋间隙    
   
	private String abnormalPercussionNote; //异常叩诊音    
   
	private String moveLeft; //移动度左    
   
	private String moveRight; //移动度右    
   
	private String breath; //听诊 呼吸    
   
	private String rale; //啰音    
   
	private String breathSounds; //呼吸音    
   
	private String breathSoundsPosition; //呼吸音-性质及部位    
   
	private String voiceConduction; //触诊 语音传导    
   
	private String pleuralRale; //胸膜摩擦音    
   
	private String precordialProminence; //心 视诊 心前区隆起    
   
	private String precordialBeat; //心前区搏动    
   
	private String precordialBeatPosition; //心前区搏动位置    
   
	private String lmcl; //移位距左锁骨中线内外    
   
	private String palpateApexBeat; //触诊 心尖搏动    
   
	private String pericardialFriction; //心包摩擦感    
   
	private String shuddar; //震颤    
   
	private String tremor; //震颤-部位    
   
	private String tremorSite; //震颤-时期    
   
	private String rightIntercostal1; //右(cm)    
   
	private String leftIntercostal1; //左(cm)    
   
	private String rightIntercostal2; //右(cm)    
   
	private String leftIntercostal2; //左(cm)    
   
	private String rightIntercostal3; //右(cm)    
   
	private String leftIntercostal3; //左(cm)    
   
	private String rightIntercostal4; //右(cm)    
   
	private String leftIntercostal4; //左(cm)    
   
	private String mclFrontLine; //MCL距前正中线    
   
	private String borderRelativeDullness; //叩诊 相对浊音界    
   
	private String heartRate; //听诊 心率    
   
	private String heartRhythm; //心律    
   
	private String s1; //S1    
   
	private String s2; //S2    
   
	private String a2p2; //A2 P2    
   
	private String openingSnap; //开瓣音    
   
	private String bigBloodVesselGunshot; //大血管枪击音    
   
	private String duroziezDoubleMurmur; //Duroziez二重杂音    
   
	private String corriganPulse; //水冲脉    
   
	private String corriganPulseMurmur; //水冲脉-杂音    
   
	private String corriganPulseMurmurPosition; //水冲脉-杂音-部位及性质    
   
	private String capillaryVesselSyndrome; //毛细血管博动征    
   
	private String oddPulse; //奇脉    
   
	private String alternans; //交替脉    
   
	private String abdominalConfiguration; //腹部 望诊 外形    
   
	private String frogBelly; //蛙腹    
   
	private String gastricType; //胃型    
   
	private String intestinalType; //肠型    
   
	private String peristalticRushes; //蠕动波    
   
	private String abdominalBreathing; //腹部呼吸    
   
	private String umbilicus; //脐    
   
	private String abdominalVaricoseVein; //腹部静脉曲张    
   
	private String ventralStripe; //腹纹    
   
	private String surgicalScars; //手术疤痕    
   
	private String hernia; //疝    
   
	private String palpation; //触诊    
   
	private String palpationPosition; //触诊-部位    
   
	private String tenderness; //压痛    
   
	private String tendernessPosition; //压痛-部位    
   
	private String reboundTenderness; //反跳痛    
   
	private String reboundTendernessPosition; //反跳痛-部位    
   
	private String fluidThrill; //液波震颤    
   
	private String seismicAcoustic; //震水声    
   
	private String abdominalMass; //腹部包块    
   
	private String abdominalMassPosition; //腹部包块-部位    
   
	private String abdominalMassSize; //腹部包块-大小    
   
	private String abdominalMassNature; //腹部包块-性质    
   
	private String liver; //肝    
   
	private String liverSubcostal; //肝-肋下    
   
	private String liverFeature; //肝-特征    
   
	private String gallbladder; //胆    
   
	private String gallbladderSize; //胆-大小    
   
	private String gallbladderTenderness; //胆-压痛    
   
	private String murphy; //Murphy 征    
   
	private String spleen; //脾    
   
	private String spleenSubcostal; //脾-肋下    
   
	private String spleenFeature; //脾-特征    
   
	private String kidney; //肾    
   
	private String tenderSpotUreter; //输尿管压痛点    
   
	private String tenderSpotUreterPosition; //输尿管压痛点-部位    
   
	private String liverDullness; //叩诊 肝浊音    
   
	private String rmcl; //位于右锁骨中线肋间    
   
	private String shiftingDullness; //移动性浊音    
   
	private String renalRegionBucklePain; //肾区扣痛    
   
	private String bowelSound; //听诊 肠鸣音    
   
	private String gurgling; //气过水声    
   
	private String vascularMurmur; //血管杂音    
   
	private String vascularMurmurPosition; //血管杂音-部位    
   
	private String genitals; //生殖器    
   
	private String anorectum; //肛门直肠    
   
	private String spine; //脊柱四脚 脊柱    
   
	private String spinousProcess; //棘突    
   
	private String spinousProcessPosition; //棘突-部位    
   
	private String limb; //四肢    
   
	private String jointSwelling; //关节红肿    
   
	private String arthrocleisis; //关节强直    
   
	private String muscleTenderness; //肌肉压痛    
   
	private String muscleAtrophy; //肌肉萎缩    
   
	private String varixLowerLimb; //下肢静脉曲张    
   
	private String varixLowerLimbPosition; //下肢静脉曲张-部位及特征    
   
	private String acropachia; //杵状指    
   
	private String abdominalRadiation; //神经系统 腹壁放射    
   
	private String muscleTension; //肌张力    
	
	private String muscleTensionLevel; //肌力级别
   
	private String bicepsReflexLeft; //肱二头肌反射左    
   
	private String bicepsReflexRight; //肱二头肌反射右    
   
	private String limbParalysis; //肢体瘫痪    
   
	private String kneePhenomenonLeft; //膝腱反射左    
   
	private String kneePhenomenonRight; //膝腱反射右    
   
	private String achillesTendonReflexLeft; //跟腱反射左    
   
	private String achillesTendonReflexRight; //跟腱反射右    
   
	private String hoffmann; //Hoffmann征    
   
	private String babinski; //Babinski征    
   
	private String kernig; //Kernig征    
   
	private String routineBloodTest; //血常规    
   
	private String electrocardiogram; //心电图    
   
	private String xrayChestRadiography; //X线胸部摄片    
   
	private String bultrasonic; //B超    
   
	private String liverKidneyFunction; //肝、肾功能    
   
	private String bloodGlucoseLipid; //血糖、血脂    
   
	private String electrolytic; //电解质    
   
	private String other; //其他    
   
	private String contactAddress; //联系地址    
   
	private String ontactNumber; //联系电话 
   
	private java.util.Date createDate; //创建时间    
   
	private String delFlag; //删除标记（0：正常1：删除2：审核）    
	
	private String fullNm; //姓名
	private String photo; //头像
	private String sex; //性别
	private String age; //年龄
	private String hospitalNumber; //医院编号

	@Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProvince(){
		return province;
	}   
		
	public void setProvince(String  province){
		this.province = province;
	}   
	
	public String getCity(){
		return city;
	}   
		
	public void setCity(String  city){
		this.city = city;
	}   
	
	public String getArea(){
		return area;
	}   
		
	public void setArea(String  area){
		this.area = area;
	}   
	
	public String getAddress(){
		return address;
	}   
		
	public void setAddress(String  address){
		this.address = address.trim();
	}   
	
	public String getMaritalStatus(){
		return maritalStatus;
	}   
		
	public void setMaritalStatus(String  maritalStatus){
		this.maritalStatus = maritalStatus;
	}   
	
	public String getNation(){
		return nation;
	}   
		
	public void setNation(String  nation){
		this.nation = nation.trim();
	}   
	
	public String getRelator(){
		return relator;
	}   
		
	public void setRelator(String  relator){
		this.relator = relator.trim();
	}   
	
	public String getRelation(){
		return relation;
	}   
		
	public void setRelation(String  relation){
		this.relation = relation.trim();
	}   
	
	public java.util.Date getArrivalDate(){
		return arrivalDate;
	}   
		
	public void setArrivalDate(java.util.Date  arrivalDate){
		this.arrivalDate = arrivalDate;
	}   
	
	public String getArrivalReason(){
		return arrivalReason;
	}   
		
	public void setArrivalReason(String  arrivalReason){
		this.arrivalReason = arrivalReason.trim();
	}   
	
	public String getEmotion(){
		return emotion;
	}   
		
	public void setEmotion(String  emotion){
		this.emotion = emotion;
	}   
	
	public String getSomnus(){
		return somnus;
	}   
		
	public void setSomnus(String  somnus){
		this.somnus = somnus;
	}   
	
	public String getSpirit(){
		return spirit;
	}   
		
	public void setSpirit(String  spirit){
		this.spirit = spirit;
	}   
	
	public String getOrexia(){
		return orexia;
	}   
		
	public void setOrexia(String  orexia){
		this.orexia = orexia;
	}   
	
	public String getHabitsCustoms(){
		return habitsCustoms;
	}   
		
	public void setHabitsCustoms(String  habitsCustoms){
		this.habitsCustoms = habitsCustoms;
	}   
	
	public String getShit(){
		return shit;
	}   
		
	public void setShit(String  shit){
		this.shit = shit;
	}   
	
	public Integer getLooseStoolsNumber(){
		return looseStoolsNumber;
	}   
		
	public void setLooseStoolsNumber(Integer  looseStoolsNumber){
		this.looseStoolsNumber = looseStoolsNumber;
	}   
	
	public Integer getLooseStoolsDays(){
		return looseStoolsDays;
	}   
		
	public void setLooseStoolsDays(Integer  looseStoolsDays){
		this.looseStoolsDays = looseStoolsDays;
	}   
	
	public String getLifeSelfAbility(){
		return lifeSelfAbility;
	}   
		
	public void setLifeSelfAbility(String  lifeSelfAbility){
		this.lifeSelfAbility = lifeSelfAbility;
	}   
	
	public String getPee(){
		return pee;
	}   
		
	public void setPee(String  pee){
		this.pee = pee;
	}   
	
	public String getHealthCondition(){
		return healthCondition;
	}   
		
	public void setHealthCondition(String  healthCondition){
		this.healthCondition = healthCondition;
	}   
	
	public String getDiseaseNm1(){
		return diseaseNm1;
	}   
		
	public void setDiseaseNm1(String  diseaseNm1){
		this.diseaseNm1 = diseaseNm1.trim();
	}   
	
	public Integer getDiseaseYear1(){
		return diseaseYear1;
	}   
		
	public void setDiseaseYear1(Integer  diseaseYear1){
		this.diseaseYear1 = diseaseYear1;
	}   
	
	public String getDiagnosedHospital1(){
		return diagnosedHospital1;
	}   
		
	public void setDiagnosedHospital1(String  diagnosedHospital1){
		this.diagnosedHospital1 = diagnosedHospital1.trim();
	}   
	
	public String getDiseaseNm2(){
		return diseaseNm2;
	}   
		
	public void setDiseaseNm2(String  diseaseNm2){
		this.diseaseNm2 = diseaseNm2.trim();
	}   
	
	public Integer getDiseaseYear2(){
		return diseaseYear2;
	}   
		
	public void setDiseaseYear2(Integer  diseaseYear2){
		this.diseaseYear2 = diseaseYear2;
	}   
	
	public String getDiagnosedHospital2(){
		return diagnosedHospital2;
	}   
		
	public void setDiagnosedHospital2(String  diagnosedHospital2){
		this.diagnosedHospital2 = diagnosedHospital2.trim();
	}   
	
	public String getDiseaseNm3(){
		return diseaseNm3;
	}   
		
	public void setDiseaseNm3(String  diseaseNm3){
		this.diseaseNm3 = diseaseNm3.trim();
	}   
	
	public Integer getDiseaseYear3(){
		return diseaseYear3;
	}   
		
	public void setDiseaseYear3(Integer  diseaseYear3){
		this.diseaseYear3 = diseaseYear3;
	}   
	
	public String getDiagnosedHospital3(){
		return diagnosedHospital3;
	}   
		
	public void setDiagnosedHospital3(String  diagnosedHospital3){
		this.diagnosedHospital3 = diagnosedHospital3.trim();
	}   
	
	public String getDiseaseNm4(){
		return diseaseNm4;
	}   
		
	public void setDiseaseNm4(String  diseaseNm4){
		this.diseaseNm4 = diseaseNm4.trim();
	}   
	
	public Integer getDiseaseYear4(){
		return diseaseYear4;
	}   
		
	public void setDiseaseYear4(Integer  diseaseYear4){
		this.diseaseYear4 = diseaseYear4;
	}   
	
	public String getDiagnosedHospital4(){
		return diagnosedHospital4;
	}   
		
	public void setDiagnosedHospital4(String  diagnosedHospital4){
		this.diagnosedHospital4 = diagnosedHospital4.trim();
	}   
	
	public String getDiseaseNm5(){
		return diseaseNm5;
	}   
		
	public void setDiseaseNm5(String  diseaseNm5){
		this.diseaseNm5 = diseaseNm5.trim();
	}   
	
	public Integer getDiseaseYear5(){
		return diseaseYear5;
	}   
		
	public void setDiseaseYear5(Integer  diseaseYear5){
		this.diseaseYear5 = diseaseYear5;
	}   
	
	public String getDiagnosedHospital5(){
		return diagnosedHospital5;
	}   
		
	public void setDiagnosedHospital5(String  diagnosedHospital5){
		this.diagnosedHospital5 = diagnosedHospital5.trim();
	}   
	
	public String getInfectionHistory(){
		return infectionHistory;
	}   
		
	public void setInfectionHistory(String  infectionHistory){
		this.infectionHistory = infectionHistory;
	}   
	
	public String getBloodHistory(){
		return bloodHistory;
	}   
		
	public void setBloodHistory(String  bloodHistory){
		this.bloodHistory = bloodHistory;
	}   
	
	public String getAllergyHistory(){
		return allergyHistory;
	}   
		
	public void setAllergyHistory(String  allergyHistory){
		this.allergyHistory = allergyHistory;
	}   
	
	public String getAnaphylactogen(){
		return anaphylactogen;
	}   
		
	public void setAnaphylactogen(String  anaphylactogen){
		this.anaphylactogen = anaphylactogen.trim();
	}   
	
	public String getAllergyClinicalManifestation(){
		return allergyClinicalManifestation;
	}   
		
	public void setAllergyClinicalManifestation(String  allergyClinicalManifestation){
		this.allergyClinicalManifestation = allergyClinicalManifestation.trim();
	}   
	
	public String getVaccinationHistory(){
		return vaccinationHistory;
	}   
		
	public void setVaccinationHistory(String  vaccinationHistory){
		this.vaccinationHistory = vaccinationHistory;
	}   
	
	public String getLocalLesionHistory(){
		return localLesionHistory;
	}   
		
	public void setLocalLesionHistory(String  localLesionHistory){
		this.localLesionHistory = localLesionHistory;
	}   
	
	public String getTraumaSurgeryHistory(){
		return traumaSurgeryHistory;
	}   
		
	public void setTraumaSurgeryHistory(String  traumaSurgeryHistory){
		this.traumaSurgeryHistory = traumaSurgeryHistory;
	}   
	
	public String getRespiratorySystem(){
		return respiratorySystem;
	}   
		
	public void setRespiratorySystem(String  respiratorySystem){
		this.respiratorySystem = respiratorySystem;
	}   
	
	public String getCirculatorySystem(){
		return circulatorySystem;
	}   
		
	public void setCirculatorySystem(String  circulatorySystem){
		this.circulatorySystem = circulatorySystem;
	}   
	
	public String getAlimentarySystem(){
		return alimentarySystem;
	}   
		
	public void setAlimentarySystem(String  alimentarySystem){
		this.alimentarySystem = alimentarySystem;
	}   
	
	public String getUrogenitalSystem(){
		return urogenitalSystem;
	}   
		
	public void setUrogenitalSystem(String  urogenitalSystem){
		this.urogenitalSystem = urogenitalSystem;
	}   
	
	public String getBloodSystem(){
		return bloodSystem;
	}   
		
	public void setBloodSystem(String  bloodSystem){
		this.bloodSystem = bloodSystem;
	}   
	
	public String getEndocrineMetabolicSystem(){
		return endocrineMetabolicSystem;
	}   
		
	public void setEndocrineMetabolicSystem(String  endocrineMetabolicSystem){
		this.endocrineMetabolicSystem = endocrineMetabolicSystem;
	}   
	
	public String getNervousSystem(){
		return nervousSystem;
	}   
		
	public void setNervousSystem(String  nervousSystem){
		this.nervousSystem = nervousSystem;
	}   
	
	public String getMovingSkeletalSystem(){
		return movingSkeletalSystem;
	}   
		
	public void setMovingSkeletalSystem(String  movingSkeletalSystem){
		this.movingSkeletalSystem = movingSkeletalSystem;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature.trim();
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse.trim();
	}

	public String getBreathingRate() {
		return breathingRate;
	}

	public void setBreathingRate(String breathingRate) {
		this.breathingRate = breathingRate.trim();
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure.trim();
	}

	public String getAuxe() {
		return auxe;
	}

	public void setAuxe(String auxe) {
		this.auxe = auxe;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getConsciousness() {
		return consciousness;
	}

	public void setConsciousness(String consciousness) {
		this.consciousness = consciousness;
	}

	public String getNutrition() {
		return nutrition;
	}

	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getGait() {
		return gait;
	}

	public void setGait(String gait) {
		this.gait = gait;
	}

	public String getCooperateInspect() {
		return cooperateInspect;
	}

	public void setCooperateInspect(String cooperateInspect) {
		this.cooperateInspect = cooperateInspect;
	}

	public String getPigment() {
		return pigment;
	}

	public void setPigment(String pigment) {
		this.pigment = pigment;
	}

	public String getErythra() {
		return erythra;
	}

	public void setErythra(String erythra) {
		this.erythra = erythra;
	}

	public String getErythraType() {
		return erythraType;
	}

	public void setErythraType(String erythraType) {
		this.erythraType = erythraType.trim();
	}

	public String getSubcutaneousHemorrhage() {
		return subcutaneousHemorrhage;
	}

	public void setSubcutaneousHemorrhage(String subcutaneousHemorrhage) {
		this.subcutaneousHemorrhage = subcutaneousHemorrhage;
	}

	public String getSubcutaneousHemorrhageType() {
		return subcutaneousHemorrhageType;
	}

	public void setSubcutaneousHemorrhageType(String subcutaneousHemorrhageType) {
		this.subcutaneousHemorrhageType = subcutaneousHemorrhageType.trim();
	}

	public String getHairDistribution() {
		return hairDistribution;
	}

	public void setHairDistribution(String hairDistribution) {
		this.hairDistribution = hairDistribution;
	}

	public String getHairDistributionPosition() {
		return hairDistributionPosition;
	}

	public void setHairDistributionPosition(String hairDistributionPosition) {
		this.hairDistributionPosition = hairDistributionPosition.trim();
	}

	public String getEdema() {
		return edema;
	}

	public void setEdema(String edema) {
		this.edema = edema;
	}

	public String getEdemaPosition() {
		return edemaPosition;
	}

	public void setEdemaPosition(String edemaPosition) {
		this.edemaPosition = edemaPosition.trim();
	}

	public String getSpider() {
		return spider;
	}

	public void setSpider(String spider) {
		this.spider = spider;
	}

	public String getSpiderPosition() {
		return spiderPosition;
	}

	public void setSpiderPosition(String spiderPosition) {
		this.spiderPosition = spiderPosition.trim();
	}

	public String getLiverPalms() {
		return liverPalms;
	}

	public void setLiverPalms(String liverPalms) {
		this.liverPalms = liverPalms;
	}

	public String getTemperatureHumidity() {
		return temperatureHumidity;
	}

	public void setTemperatureHumidity(String temperatureHumidity) {
		this.temperatureHumidity = temperatureHumidity;
	}

	public String getElastic() {
		return elastic;
	}

	public void setElastic(String elastic) {
		this.elastic = elastic;
	}

	public String getSuperficialLymphNodes() {
		return superficialLymphNodes;
	}

	public void setSuperficialLymphNodes(String superficialLymphNodes) {
		this.superficialLymphNodes = superficialLymphNodes;
	}

	public String getSuperficialLymphNodesPosition() {
		return superficialLymphNodesPosition;
	}

	public void setSuperficialLymphNodesPosition(String superficialLymphNodesPosition) {
		this.superficialLymphNodesPosition = superficialLymphNodesPosition.trim();
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getMalformation() {
		return malformation;
	}

	public void setMalformation(String malformation) {
		this.malformation = malformation;
	}

	public String getHeadTenderness() {
		return headTenderness;
	}

	public void setHeadTenderness(String headTenderness) {
		this.headTenderness = headTenderness;
	}

	public String getHeadEnclosedMass() {
		return headEnclosedMass;
	}

	public void setHeadEnclosedMass(String headEnclosedMass) {
		this.headEnclosedMass = headEnclosedMass;
	}

	public String getConcaveLimit() {
		return concaveLimit;
	}

	public void setConcaveLimit(String concaveLimit) {
		this.concaveLimit = concaveLimit;
	}

	public String getEyelid() {
		return eyelid;
	}

	public void setEyelid(String eyelid) {
		this.eyelid = eyelid;
	}

	public String getConjunctiva() {
		return conjunctiva;
	}

	public void setConjunctiva(String conjunctiva) {
		this.conjunctiva = conjunctiva;
	}

	public String getEyeball() {
		return eyeball;
	}

	public void setEyeball(String eyeball) {
		this.eyeball = eyeball;
	}

	public String getAlbugineaOculi() {
		return albugineaOculi;
	}

	public void setAlbugineaOculi(String albugineaOculi) {
		this.albugineaOculi = albugineaOculi;
	}

	public String getCerato() {
		return cerato;
	}

	public void setCerato(String cerato) {
		this.cerato = cerato;
	}

	public String getPupil() {
		return pupil;
	}

	public void setPupil(String pupil) {
		this.pupil = pupil;
	}

	public String getLightReaction() {
		return lightReaction;
	}

	public void setLightReaction(String lightReaction) {
		this.lightReaction = lightReaction;
	}

	public String getAuricle() {
		return auricle;
	}

	public void setAuricle(String auricle) {
		this.auricle = auricle;
	}

	public String getExternalSecretion() {
		return externalSecretion;
	}

	public void setExternalSecretion(String externalSecretion) {
		this.externalSecretion = externalSecretion;
	}

	public String getExternalSecretionNature() {
		return externalSecretionNature;
	}

	public void setExternalSecretionNature(String externalSecretionNature) {
		this.externalSecretionNature = externalSecretionNature.trim();
	}

	public String getSternocleidomastoidPain() {
		return sternocleidomastoidPain;
	}

	public void setSternocleidomastoidPain(String sternocleidomastoidPain) {
		this.sternocleidomastoidPain = sternocleidomastoidPain;
	}

	public String getCoarseHearingImpairment() {
		return coarseHearingImpairment;
	}

	public void setCoarseHearingImpairment(String coarseHearingImpairment) {
		this.coarseHearingImpairment = coarseHearingImpairment;
	}

	public String getNoseContour() {
		return noseContour;
	}

	public void setNoseContour(String noseContour) {
		this.noseContour = noseContour;
	}

	public String getOtherAnomalies() {
		return otherAnomalies;
	}

	public void setOtherAnomalies(String otherAnomalies) {
		this.otherAnomalies = otherAnomalies;
	}

	public String getNasalSinusTenderness() {
		return nasalSinusTenderness;
	}

	public void setNasalSinusTenderness(String nasalSinusTenderness) {
		this.nasalSinusTenderness = nasalSinusTenderness;
	}

	public String getLip() {
		return lip;
	}

	public void setLip(String lip) {
		this.lip = lip;
	}

	public String getMucousCoat() {
		return mucousCoat;
	}

	public void setMucousCoat(String mucousCoat) {
		this.mucousCoat = mucousCoat;
	}

	public String getParotidDuctOpening() {
		return parotidDuctOpening;
	}

	public void setParotidDuctOpening(String parotidDuctOpening) {
		this.parotidDuctOpening = parotidDuctOpening;
	}

	public String getTongue() {
		return tongue;
	}

	public void setTongue(String tongue) {
		this.tongue = tongue;
	}

	public String getGingiva() {
		return gingiva;
	}

	public void setGingiva(String gingiva) {
		this.gingiva = gingiva;
	}

	public String getDentition() {
		return dentition;
	}

	public void setDentition(String dentition) {
		this.dentition = dentition;
	}

	public String getAgomphosisNumber() {
		return agomphosisNumber;
	}

	public void setAgomphosisNumber(String agomphosisNumber) {
		this.agomphosisNumber = agomphosisNumber;
	}

	public String getTonsilla() {
		return tonsilla;
	}

	public void setTonsilla(String tonsilla) {
		this.tonsilla = tonsilla;
	}

	public String getTonsillaFester() {
		return tonsillaFester;
	}

	public void setTonsillaFester(String tonsillaFester) {
		this.tonsillaFester = tonsillaFester;
	}

	public String getPharynx() {
		return pharynx;
	}

	public void setPharynx(String pharynx) {
		this.pharynx = pharynx;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getSenseResistance() {
		return senseResistance;
	}

	public void setSenseResistance(String senseResistance) {
		this.senseResistance = senseResistance;
	}

	public String getStiffnessArteryFluctuation() {
		return stiffnessArteryFluctuation;
	}

	public void setStiffnessArteryFluctuation(String stiffnessArteryFluctuation) {
		this.stiffnessArteryFluctuation = stiffnessArteryFluctuation;
	}

	public String getJugularVein() {
		return jugularVein;
	}

	public void setJugularVein(String jugularVein) {
		this.jugularVein = jugularVein;
	}

	public String getTrachea() {
		return trachea;
	}

	public void setTrachea(String trachea) {
		this.trachea = trachea;
	}

	public String getHepatojugularReflux() {
		return hepatojugularReflux;
	}

	public void setHepatojugularReflux(String hepatojugularReflux) {
		this.hepatojugularReflux = hepatojugularReflux;
	}

	public String getThyroid() {
		return thyroid;
	}

	public void setThyroid(String thyroid) {
		this.thyroid = thyroid;
	}

	public String getThyroidTumefaction() {
		return thyroidTumefaction;
	}

	public void setThyroidTumefaction(String thyroidTumefaction) {
		this.thyroidTumefaction = thyroidTumefaction;
	}

	public String getLeftRightSidesMainly() {
		return leftRightSidesMainly;
	}

	public void setLeftRightSidesMainly(String leftRightSidesMainly) {
		this.leftRightSidesMainly = leftRightSidesMainly;
	}

	public String getThorax() {
		return thorax;
	}

	public void setThorax(String thorax) {
		this.thorax = thorax;
	}

	public String getBreast() {
		return breast;
	}

	public void setBreast(String breast) {
		this.breast = breast;
	}

	public String getBreastEnclosedMass() {
		return breastEnclosedMass;
	}

	public void setBreastEnclosedMass(String breastEnclosedMass) {
		this.breastEnclosedMass = breastEnclosedMass;
	}

	public String getBreastTenderness() {
		return breastTenderness;
	}

	public void setBreastTenderness(String breastTenderness) {
		this.breastTenderness = breastTenderness;
	}

	public String getExcreta() {
		return excreta;
	}

	public void setExcreta(String excreta) {
		this.excreta = excreta;
	}

	public String getRespiratoryMovement() {
		return respiratoryMovement;
	}

	public void setRespiratoryMovement(String respiratoryMovement) {
		this.respiratoryMovement = respiratoryMovement;
	}

	public String getRibSpace() {
		return ribSpace;
	}

	public void setRibSpace(String ribSpace) {
		this.ribSpace = ribSpace;
	}

	public String getRibSpacePosition() {
		return ribSpacePosition;
	}

	public void setRibSpacePosition(String ribSpacePosition) {
		this.ribSpacePosition = ribSpacePosition.trim();
	}

	public String getVocalFremitus() {
		return vocalFremitus;
	}

	public void setVocalFremitus(String vocalFremitus) {
		this.vocalFremitus = vocalFremitus;
	}

	public String getPleuralFriction() {
		return pleuralFriction;
	}

	public void setPleuralFriction(String pleuralFriction) {
		this.pleuralFriction = pleuralFriction;
	}

	public String getPleuralFrictionPosition() {
		return pleuralFrictionPosition;
	}

	public void setPleuralFrictionPosition(String pleuralFrictionPosition) {
		this.pleuralFrictionPosition = pleuralFrictionPosition.trim();
	}

	public String getSubcutaneousCrepitus() {
		return subcutaneousCrepitus;
	}

	public void setSubcutaneousCrepitus(String subcutaneousCrepitus) {
		this.subcutaneousCrepitus = subcutaneousCrepitus;
	}

	public String getSubcutaneousCrepitusPosition() {
		return subcutaneousCrepitusPosition;
	}

	public void setSubcutaneousCrepitusPosition(String subcutaneousCrepitusPosition) {
		this.subcutaneousCrepitusPosition = subcutaneousCrepitusPosition.trim();
	}

	public String getPercussBucklePain() {
		return percussBucklePain;
	}

	public void setPercussBucklePain(String percussBucklePain) {
		this.percussBucklePain = percussBucklePain;
	}

	public String getScapularLineLeft() {
		return scapularLineLeft;
	}

	public void setScapularLineLeft(String scapularLineLeft) {
		this.scapularLineLeft = scapularLineLeft.trim();
	}

	public String getScapularLineRight() {
		return scapularLineRight;
	}

	public void setScapularLineRight(String scapularLineRight) {
		this.scapularLineRight = scapularLineRight.trim();
	}

	public String getAbnormalPercussionNote() {
		return abnormalPercussionNote;
	}

	public void setAbnormalPercussionNote(String abnormalPercussionNote) {
		this.abnormalPercussionNote = abnormalPercussionNote;
	}

	public String getMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(String moveLeft) {
		this.moveLeft = moveLeft;
	}

	public String getMoveRight() {
		return moveRight;
	}

	public void setMoveRight(String moveRight) {
		this.moveRight = moveRight;
	}

	public String getBreath() {
		return breath;
	}

	public void setBreath(String breath) {
		this.breath = breath;
	}

	public String getRale() {
		return rale;
	}

	public void setRale(String rale) {
		this.rale = rale;
	}

	public String getBreathSounds() {
		return breathSounds;
	}

	public void setBreathSounds(String breathSounds) {
		this.breathSounds = breathSounds;
	}

	public String getBreathSoundsPosition() {
		return breathSoundsPosition;
	}

	public void setBreathSoundsPosition(String breathSoundsPosition) {
		this.breathSoundsPosition = breathSoundsPosition.trim();
	}

	public String getVoiceConduction() {
		return voiceConduction;
	}

	public void setVoiceConduction(String voiceConduction) {
		this.voiceConduction = voiceConduction;
	}

	public String getPleuralRale() {
		return pleuralRale;
	}

	public void setPleuralRale(String pleuralRale) {
		this.pleuralRale = pleuralRale;
	}

	public String getPrecordialProminence() {
		return precordialProminence;
	}

	public void setPrecordialProminence(String precordialProminence) {
		this.precordialProminence = precordialProminence;
	}

	public String getPrecordialBeat() {
		return precordialBeat;
	}

	public void setPrecordialBeat(String precordialBeat) {
		this.precordialBeat = precordialBeat;
	}

	public String getPrecordialBeatPosition() {
		return precordialBeatPosition;
	}

	public void setPrecordialBeatPosition(String precordialBeatPosition) {
		this.precordialBeatPosition = precordialBeatPosition.trim();
	}

	public String getLmcl() {
		return lmcl;
	}

	public void setLmcl(String lmcl) {
		this.lmcl = lmcl;
	}

	public String getPalpateApexBeat() {
		return palpateApexBeat;
	}

	public void setPalpateApexBeat(String palpateApexBeat) {
		this.palpateApexBeat = palpateApexBeat;
	}

	public String getPericardialFriction() {
		return pericardialFriction;
	}

	public void setPericardialFriction(String pericardialFriction) {
		this.pericardialFriction = pericardialFriction;
	}

	public String getShuddar() {
		return shuddar;
	}

	public void setShuddar(String shuddar) {
		this.shuddar = shuddar;
	}

	public String getTremor() {
		return tremor;
	}

	public void setTremor(String tremor) {
		this.tremor = tremor;
	}

	public String getTremorSite() {
		return tremorSite;
	}

	public void setTremorSite(String tremorSite) {
		this.tremorSite = tremorSite;
	}

	public String getRightIntercostal1() {
		return rightIntercostal1;
	}

	public void setRightIntercostal1(String rightIntercostal1) {
		this.rightIntercostal1 = rightIntercostal1;
	}

	public String getLeftIntercostal1() {
		return leftIntercostal1;
	}

	public void setLeftIntercostal1(String leftIntercostal1) {
		this.leftIntercostal1 = leftIntercostal1;
	}

	public String getRightIntercostal2() {
		return rightIntercostal2;
	}

	public void setRightIntercostal2(String rightIntercostal2) {
		this.rightIntercostal2 = rightIntercostal2;
	}

	public String getLeftIntercostal2() {
		return leftIntercostal2;
	}

	public void setLeftIntercostal2(String leftIntercostal2) {
		this.leftIntercostal2 = leftIntercostal2;
	}

	public String getRightIntercostal3() {
		return rightIntercostal3;
	}

	public void setRightIntercostal3(String rightIntercostal3) {
		this.rightIntercostal3 = rightIntercostal3;
	}

	public String getLeftIntercostal3() {
		return leftIntercostal3;
	}

	public void setLeftIntercostal3(String leftIntercostal3) {
		this.leftIntercostal3 = leftIntercostal3;
	}

	public String getRightIntercostal4() {
		return rightIntercostal4;
	}

	public void setRightIntercostal4(String rightIntercostal4) {
		this.rightIntercostal4 = rightIntercostal4;
	}

	public String getLeftIntercostal4() {
		return leftIntercostal4;
	}

	public void setLeftIntercostal4(String leftIntercostal4) {
		this.leftIntercostal4 = leftIntercostal4;
	}

	public String getMclFrontLine() {
		return mclFrontLine;
	}

	public void setMclFrontLine(String mclFrontLine) {
		this.mclFrontLine = mclFrontLine;
	}

	public String getBorderRelativeDullness() {
		return borderRelativeDullness;
	}

	public void setBorderRelativeDullness(String borderRelativeDullness) {
		this.borderRelativeDullness = borderRelativeDullness;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getHeartRhythm() {
		return heartRhythm;
	}

	public void setHeartRhythm(String heartRhythm) {
		this.heartRhythm = heartRhythm;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getA2p2() {
		return a2p2;
	}

	public void setA2p2(String a2p2) {
		this.a2p2 = a2p2;
	}

	public String getOpeningSnap() {
		return openingSnap;
	}

	public void setOpeningSnap(String openingSnap) {
		this.openingSnap = openingSnap;
	}

	public String getBigBloodVesselGunshot() {
		return bigBloodVesselGunshot;
	}

	public void setBigBloodVesselGunshot(String bigBloodVesselGunshot) {
		this.bigBloodVesselGunshot = bigBloodVesselGunshot;
	}

	public String getDuroziezDoubleMurmur() {
		return duroziezDoubleMurmur;
	}

	public void setDuroziezDoubleMurmur(String duroziezDoubleMurmur) {
		this.duroziezDoubleMurmur = duroziezDoubleMurmur;
	}

	public String getCorriganPulse() {
		return corriganPulse;
	}

	public void setCorriganPulse(String corriganPulse) {
		this.corriganPulse = corriganPulse;
	}

	public String getCorriganPulseMurmur() {
		return corriganPulseMurmur;
	}

	public void setCorriganPulseMurmur(String corriganPulseMurmur) {
		this.corriganPulseMurmur = corriganPulseMurmur;
	}

	public String getCorriganPulseMurmurPosition() {
		return corriganPulseMurmurPosition;
	}

	public void setCorriganPulseMurmurPosition(String corriganPulseMurmurPosition) {
		this.corriganPulseMurmurPosition = corriganPulseMurmurPosition.trim();
	}

	public String getCapillaryVesselSyndrome() {
		return capillaryVesselSyndrome;
	}

	public void setCapillaryVesselSyndrome(String capillaryVesselSyndrome) {
		this.capillaryVesselSyndrome = capillaryVesselSyndrome;
	}

	public String getOddPulse() {
		return oddPulse;
	}

	public void setOddPulse(String oddPulse) {
		this.oddPulse = oddPulse;
	}

	public String getAlternans() {
		return alternans;
	}

	public void setAlternans(String alternans) {
		this.alternans = alternans;
	}

	public String getAbdominalConfiguration() {
		return abdominalConfiguration;
	}

	public void setAbdominalConfiguration(String abdominalConfiguration) {
		this.abdominalConfiguration = abdominalConfiguration;
	}

	public String getFrogBelly() {
		return frogBelly;
	}

	public void setFrogBelly(String frogBelly) {
		this.frogBelly = frogBelly;
	}

	public String getGastricType() {
		return gastricType;
	}

	public void setGastricType(String gastricType) {
		this.gastricType = gastricType;
	}

	public String getIntestinalType() {
		return intestinalType;
	}

	public void setIntestinalType(String intestinalType) {
		this.intestinalType = intestinalType;
	}

	public String getPeristalticRushes() {
		return peristalticRushes;
	}

	public void setPeristalticRushes(String peristalticRushes) {
		this.peristalticRushes = peristalticRushes;
	}

	public String getAbdominalBreathing() {
		return abdominalBreathing;
	}

	public void setAbdominalBreathing(String abdominalBreathing) {
		this.abdominalBreathing = abdominalBreathing;
	}

	public String getUmbilicus() {
		return umbilicus;
	}

	public void setUmbilicus(String umbilicus) {
		this.umbilicus = umbilicus;
	}

	public String getAbdominalVaricoseVein() {
		return abdominalVaricoseVein;
	}

	public void setAbdominalVaricoseVein(String abdominalVaricoseVein) {
		this.abdominalVaricoseVein = abdominalVaricoseVein;
	}

	public String getVentralStripe() {
		return ventralStripe;
	}

	public void setVentralStripe(String ventralStripe) {
		this.ventralStripe = ventralStripe;
	}

	public String getSurgicalScars() {
		return surgicalScars;
	}

	public void setSurgicalScars(String surgicalScars) {
		this.surgicalScars = surgicalScars;
	}

	public String getHernia() {
		return hernia;
	}

	public void setHernia(String hernia) {
		this.hernia = hernia;
	}

	public String getPalpation() {
		return palpation;
	}

	public void setPalpation(String palpation) {
		this.palpation = palpation;
	}

	public String getPalpationPosition() {
		return palpationPosition;
	}

	public void setPalpationPosition(String palpationPosition) {
		this.palpationPosition = palpationPosition.trim();
	}

	public String getTenderness() {
		return tenderness;
	}

	public void setTenderness(String tenderness) {
		this.tenderness = tenderness;
	}

	public String getTendernessPosition() {
		return tendernessPosition;
	}

	public void setTendernessPosition(String tendernessPosition) {
		this.tendernessPosition = tendernessPosition.trim();
	}

	public String getReboundTenderness() {
		return reboundTenderness;
	}

	public void setReboundTenderness(String reboundTenderness) {
		this.reboundTenderness = reboundTenderness;
	}

	public String getReboundTendernessPosition() {
		return reboundTendernessPosition;
	}

	public void setReboundTendernessPosition(String reboundTendernessPosition) {
		this.reboundTendernessPosition = reboundTendernessPosition.trim();
	}

	public String getFluidThrill() {
		return fluidThrill;
	}

	public void setFluidThrill(String fluidThrill) {
		this.fluidThrill = fluidThrill;
	}

	public String getSeismicAcoustic() {
		return seismicAcoustic;
	}

	public void setSeismicAcoustic(String seismicAcoustic) {
		this.seismicAcoustic = seismicAcoustic;
	}

	public String getAbdominalMass() {
		return abdominalMass;
	}

	public void setAbdominalMass(String abdominalMass) {
		this.abdominalMass = abdominalMass;
	}

	public String getAbdominalMassPosition() {
		return abdominalMassPosition;
	}

	public void setAbdominalMassPosition(String abdominalMassPosition) {
		this.abdominalMassPosition = abdominalMassPosition.trim();
	}

	public String getAbdominalMassSize() {
		return abdominalMassSize;
	}

	public void setAbdominalMassSize(String abdominalMassSize) {
		this.abdominalMassSize = abdominalMassSize;
	}

	public String getAbdominalMassNature() {
		return abdominalMassNature;
	}

	public void setAbdominalMassNature(String abdominalMassNature) {
		this.abdominalMassNature = abdominalMassNature.trim();
	}

	public String getLiver() {
		return liver;
	}

	public void setLiver(String liver) {
		this.liver = liver;
	}

	public String getLiverSubcostal() {
		return liverSubcostal;
	}

	public void setLiverSubcostal(String liverSubcostal) {
		this.liverSubcostal = liverSubcostal;
	}

	public String getLiverFeature() {
		return liverFeature;
	}

	public void setLiverFeature(String liverFeature) {
		this.liverFeature = liverFeature.trim();
	}

	public String getGallbladder() {
		return gallbladder;
	}

	public void setGallbladder(String gallbladder) {
		this.gallbladder = gallbladder;
	}

	public String getGallbladderSize() {
		return gallbladderSize;
	}

	public void setGallbladderSize(String gallbladderSize) {
		this.gallbladderSize = gallbladderSize;
	}

	public String getGallbladderTenderness() {
		return gallbladderTenderness;
	}

	public void setGallbladderTenderness(String gallbladderTenderness) {
		this.gallbladderTenderness = gallbladderTenderness;
	}

	public String getMurphy() {
		return murphy;
	}

	public void setMurphy(String murphy) {
		this.murphy = murphy;
	}

	public String getSpleen() {
		return spleen;
	}

	public void setSpleen(String spleen) {
		this.spleen = spleen;
	}

	public String getSpleenSubcostal() {
		return spleenSubcostal;
	}

	public void setSpleenSubcostal(String spleenSubcostal) {
		this.spleenSubcostal = spleenSubcostal;
	}

	public String getSpleenFeature() {
		return spleenFeature;
	}

	public void setSpleenFeature(String spleenFeature) {
		this.spleenFeature = spleenFeature.trim();
	}

	public String getKidney() {
		return kidney;
	}

	public void setKidney(String kidney) {
		this.kidney = kidney;
	}

	public String getTenderSpotUreter() {
		return tenderSpotUreter;
	}

	public void setTenderSpotUreter(String tenderSpotUreter) {
		this.tenderSpotUreter = tenderSpotUreter;
	}

	public String getTenderSpotUreterPosition() {
		return tenderSpotUreterPosition;
	}

	public void setTenderSpotUreterPosition(String tenderSpotUreterPosition) {
		this.tenderSpotUreterPosition = tenderSpotUreterPosition.trim();
	}

	public String getLiverDullness() {
		return liverDullness;
	}

	public void setLiverDullness(String liverDullness) {
		this.liverDullness = liverDullness;
	}

	public String getRmcl() {
		return rmcl;
	}

	public void setRmcl(String rmcl) {
		this.rmcl = rmcl.trim();
	}

	public String getShiftingDullness() {
		return shiftingDullness;
	}

	public void setShiftingDullness(String shiftingDullness) {
		this.shiftingDullness = shiftingDullness;
	}

	public String getRenalRegionBucklePain() {
		return renalRegionBucklePain;
	}

	public void setRenalRegionBucklePain(String renalRegionBucklePain) {
		this.renalRegionBucklePain = renalRegionBucklePain;
	}

	public String getBowelSound() {
		return bowelSound;
	}

	public void setBowelSound(String bowelSound) {
		this.bowelSound = bowelSound;
	}

	public String getGurgling() {
		return gurgling;
	}

	public void setGurgling(String gurgling) {
		this.gurgling = gurgling;
	}

	public String getVascularMurmur() {
		return vascularMurmur;
	}

	public void setVascularMurmur(String vascularMurmur) {
		this.vascularMurmur = vascularMurmur;
	}

	public String getVascularMurmurPosition() {
		return vascularMurmurPosition;
	}

	public void setVascularMurmurPosition(String vascularMurmurPosition) {
		this.vascularMurmurPosition = vascularMurmurPosition.trim();
	}

	public String getGenitals() {
		return genitals;
	}

	public void setGenitals(String genitals) {
		this.genitals = genitals;
	}

	public String getAnorectum() {
		return anorectum;
	}

	public void setAnorectum(String anorectum) {
		this.anorectum = anorectum;
	}

	public String getSpine() {
		return spine;
	}

	public void setSpine(String spine) {
		this.spine = spine;
	}

	public String getSpinousProcess() {
		return spinousProcess;
	}

	public void setSpinousProcess(String spinousProcess) {
		this.spinousProcess = spinousProcess;
	}

	public String getSpinousProcessPosition() {
		return spinousProcessPosition;
	}

	public void setSpinousProcessPosition(String spinousProcessPosition) {
		this.spinousProcessPosition = spinousProcessPosition.trim();
	}

	public String getLimb() {
		return limb;
	}

	public void setLimb(String limb) {
		this.limb = limb;
	}

	public String getJointSwelling() {
		return jointSwelling;
	}

	public void setJointSwelling(String jointSwelling) {
		this.jointSwelling = jointSwelling;
	}

	public String getArthrocleisis() {
		return arthrocleisis;
	}

	public void setArthrocleisis(String arthrocleisis) {
		this.arthrocleisis = arthrocleisis;
	}

	public String getMuscleTenderness() {
		return muscleTenderness;
	}

	public void setMuscleTenderness(String muscleTenderness) {
		this.muscleTenderness = muscleTenderness;
	}

	public String getMuscleAtrophy() {
		return muscleAtrophy;
	}

	public void setMuscleAtrophy(String muscleAtrophy) {
		this.muscleAtrophy = muscleAtrophy;
	}

	public String getVarixLowerLimb() {
		return varixLowerLimb;
	}

	public void setVarixLowerLimb(String varixLowerLimb) {
		this.varixLowerLimb = varixLowerLimb;
	}

	public String getVarixLowerLimbPosition() {
		return varixLowerLimbPosition;
	}

	public void setVarixLowerLimbPosition(String varixLowerLimbPosition) {
		this.varixLowerLimbPosition = varixLowerLimbPosition.trim();
	}

	public String getAcropachia() {
		return acropachia;
	}

	public void setAcropachia(String acropachia) {
		this.acropachia = acropachia;
	}

	public String getAbdominalRadiation() {
		return abdominalRadiation;
	}

	public void setAbdominalRadiation(String abdominalRadiation) {
		this.abdominalRadiation = abdominalRadiation;
	}

	public String getMuscleTension() {
		return muscleTension;
	}

	public void setMuscleTension(String muscleTension) {
		this.muscleTension = muscleTension;
	}

	public String getMuscleTensionLevel() {
		return muscleTensionLevel;
	}

	public void setMuscleTensionLevel(String muscleTensionLevel) {
		this.muscleTensionLevel = muscleTensionLevel;
	}

	public String getBicepsReflexLeft() {
		return bicepsReflexLeft;
	}

	public void setBicepsReflexLeft(String bicepsReflexLeft) {
		this.bicepsReflexLeft = bicepsReflexLeft;
	}

	public String getBicepsReflexRight() {
		return bicepsReflexRight;
	}

	public void setBicepsReflexRight(String bicepsReflexRight) {
		this.bicepsReflexRight = bicepsReflexRight;
	}

	public String getLimbParalysis() {
		return limbParalysis;
	}

	public void setLimbParalysis(String limbParalysis) {
		this.limbParalysis = limbParalysis;
	}

	public String getKneePhenomenonLeft() {
		return kneePhenomenonLeft;
	}

	public void setKneePhenomenonLeft(String kneePhenomenonLeft) {
		this.kneePhenomenonLeft = kneePhenomenonLeft;
	}

	public String getKneePhenomenonRight() {
		return kneePhenomenonRight;
	}

	public void setKneePhenomenonRight(String kneePhenomenonRight) {
		this.kneePhenomenonRight = kneePhenomenonRight;
	}

	public String getAchillesTendonReflexLeft() {
		return achillesTendonReflexLeft;
	}

	public void setAchillesTendonReflexLeft(String achillesTendonReflexLeft) {
		this.achillesTendonReflexLeft = achillesTendonReflexLeft;
	}

	public String getAchillesTendonReflexRight() {
		return achillesTendonReflexRight;
	}

	public void setAchillesTendonReflexRight(String achillesTendonReflexRight) {
		this.achillesTendonReflexRight = achillesTendonReflexRight;
	}

	public String getHoffmann() {
		return hoffmann;
	}

	public void setHoffmann(String hoffmann) {
		this.hoffmann = hoffmann;
	}

	public String getBabinski() {
		return babinski;
	}

	public void setBabinski(String babinski) {
		this.babinski = babinski;
	}

	public String getKernig() {
		return kernig;
	}

	public void setKernig(String kernig) {
		this.kernig = kernig;
	}

	public String getRoutineBloodTest() {
		return routineBloodTest;
	}

	public void setRoutineBloodTest(String routineBloodTest) {
		this.routineBloodTest = routineBloodTest.trim();
	}

	public String getElectrocardiogram() {
		return electrocardiogram;
	}

	public void setElectrocardiogram(String electrocardiogram) {
		this.electrocardiogram = electrocardiogram.trim();
	}

	public String getXrayChestRadiography() {
		return xrayChestRadiography;
	}

	public void setXrayChestRadiography(String xrayChestRadiography) {
		this.xrayChestRadiography = xrayChestRadiography.trim();
	}

	public String getBultrasonic() {
		return bultrasonic;
	}

	public void setBultrasonic(String bultrasonic) {
		this.bultrasonic = bultrasonic.trim();
	}

	public String getLiverKidneyFunction() {
		return liverKidneyFunction;
	}

	public void setLiverKidneyFunction(String liverKidneyFunction) {
		this.liverKidneyFunction = liverKidneyFunction.trim();
	}

	public String getBloodGlucoseLipid() {
		return bloodGlucoseLipid;
	}

	public void setBloodGlucoseLipid(String bloodGlucoseLipid) {
		this.bloodGlucoseLipid = bloodGlucoseLipid.trim();
	}

	public String getElectrolytic() {
		return electrolytic;
	}

	public void setElectrolytic(String electrolytic) {
		this.electrolytic = electrolytic.trim();
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other.trim();
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress.trim();
	}

	public String getOntactNumber() {
		return ontactNumber;
	}

	public void setOntactNumber(String ontactNumber) {
		this.ontactNumber = ontactNumber.trim();
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@Transient
	public String getFullNm() {
		return fullNm;
	}

	public void setFullNm(String fullNm) {
		this.fullNm = fullNm;
	}

	@Transient
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Transient
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Transient
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		if(StringUtils.isNotBlank(hospitalNumber)){
			this.age = age;
		}else{
			this.age = age;
		}
		
	}
	@Transient
	public String getHospitalNumber() {
		return hospitalNumber;
	}

	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}   
	
	
	
}


