package metadataResources;

import java.io.File;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import dataContainer.DataWarehouse;
import dataContainer.RestResourceURL;

public class MetadataResource {
	Document doc;
	Element xmlroot;

	public MetadataResource() {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();
			xmlroot = doc.createElement("Package");
			doc.appendChild(xmlroot);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void getApexClasses(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {
		JSONArray apexclassArray = DataWarehouse.getApexClassList(loginObject, startdate, enddate, sfdcuserid);
		if (apexclassArray != null) {
			if (apexclassArray.length() > 0) {
				Element xmlapexclasstype = doc.createElement("types");
				xmlroot.appendChild(xmlapexclasstype);

				try {
					String userfullname="";
					HashSet <String> uniquecharset= new HashSet<String>();
					for (int i = 0; i < apexclassArray.length(); i++) {
						
						if(uniquecharset.add(apexclassArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, apexclassArray.getJSONObject(i).getString("LastModifiedById"));
						
						Element xmlapexclassMembers = doc.createElement("members");
						xmlapexclassMembers
								.appendChild(doc.createTextNode(apexclassArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(apexclassArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlapexclasstype.appendChild(xmlapexclassMembers);

					}
					
					Element xmlapexclassName = doc.createElement("name");
					xmlapexclassName.appendChild(doc.createTextNode("ApexClass"));
					xmlapexclasstype.appendChild(xmlapexclassName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void getApexTriggers(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {
		JSONArray apexTriggerArray = DataWarehouse.getApexTriggerList(loginObject, startdate, enddate, sfdcuserid);
	
		if (apexTriggerArray != null) {
			if (apexTriggerArray.length() > 0) {
				Element xmlapextriggertype = doc.createElement("types");
				xmlroot.appendChild(xmlapextriggertype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < apexTriggerArray.length(); i++) {
					try {
						if(uniquecharset.add(apexTriggerArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, apexTriggerArray.getJSONObject(i).getString("LastModifiedById"));
						
						Element xmlapextriggerMembers = doc.createElement("members");
						xmlapextriggerMembers
								.appendChild(doc.createTextNode(apexTriggerArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(apexTriggerArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlapextriggertype.appendChild(xmlapextriggerMembers);
	
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlapextriggerName = doc.createElement("name");
				xmlapextriggerName.appendChild(doc.createTextNode("ApexTrigger"));
				xmlapextriggertype.appendChild(xmlapextriggerName);
			}
		}

	}

	public void getApexPages(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray apexPageArray = DataWarehouse.getApexPageList(loginObject, startdate, enddate, sfdcuserid);
		if (apexPageArray != null) {
			if (apexPageArray.length() > 0) {
				Element xmlapexPagetype = doc.createElement("types");
				xmlroot.appendChild(xmlapexPagetype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < apexPageArray.length(); i++) {
					try {
						if(uniquecharset.add(apexPageArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, apexPageArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlapexPageMembers = doc.createElement("members");
						xmlapexPageMembers
								.appendChild(doc.createTextNode(apexPageArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(apexPageArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlapexPagetype.appendChild(xmlapexPageMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlapexPageName = doc.createElement("name");
				xmlapexPageName.appendChild(doc.createTextNode("ApexPage"));
				xmlapexPagetype.appendChild(xmlapexPageName);
			}
		}

	}

	public void getApexComponents(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray apexComponentArray = DataWarehouse.getApexComponentList(loginObject, startdate, enddate, sfdcuserid);
		if (apexComponentArray != null) {
			if (apexComponentArray.length() > 0) {
				Element xmlapexComponenttype = doc.createElement("types");
				xmlroot.appendChild(xmlapexComponenttype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < apexComponentArray.length(); i++) {
					try {
						if(uniquecharset.add(apexComponentArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, apexComponentArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlapexComponentMembers = doc.createElement("members");
						xmlapexComponentMembers
								.appendChild(doc.createTextNode(apexComponentArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(apexComponentArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlapexComponenttype.appendChild(xmlapexComponentMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlapexComponentName = doc.createElement("name");
				xmlapexComponentName.appendChild(doc.createTextNode("ApexComponent"));
				xmlapexComponenttype.appendChild(xmlapexComponentName);
			}
		}

	}

	public void getAssignmentRule(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray assignmentRuleArray = DataWarehouse.getAssignmentRuleList(loginObject, startdate, enddate,
				sfdcuserid);
		if (assignmentRuleArray != null) {
			if (assignmentRuleArray.length() > 0) {
				Element xmlassignmentRuletype = doc.createElement("types");
				xmlroot.appendChild(xmlassignmentRuletype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < assignmentRuleArray.length(); i++) {
					try {
						if(uniquecharset.add(assignmentRuleArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, assignmentRuleArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlassignmentRuleMembers = doc.createElement("members");
						xmlassignmentRuleMembers.appendChild(
								doc.createTextNode(assignmentRuleArray.getJSONObject(i).getString("EntityDefinitionId")
										+ "." + assignmentRuleArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(assignmentRuleArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlassignmentRuletype.appendChild(xmlassignmentRuleMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlassignmentRuleName = doc.createElement("name");
				xmlassignmentRuleName.appendChild(doc.createTextNode("AssignmentRule"));
				xmlassignmentRuletype.appendChild(xmlassignmentRuleName);
			}
		}

	}

	public void getAuraDefinitionBundle(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray auraDefinitionBundleArray = DataWarehouse.getAuraDefinitionBundleList(loginObject, startdate, enddate,
				sfdcuserid);
		if (auraDefinitionBundleArray != null) {
			if (auraDefinitionBundleArray.length() > 0) {
				Element xmlAuraDefinitionBundletype = doc.createElement("types");
				xmlroot.appendChild(xmlAuraDefinitionBundletype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				try {
					for (int i = 0; i < auraDefinitionBundleArray.length(); i++) {
						if(uniquecharset.add(auraDefinitionBundleArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, auraDefinitionBundleArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlAuraDefinitionBundleMembers = doc.createElement("members");
						xmlAuraDefinitionBundleMembers.appendChild(doc
								.createTextNode(auraDefinitionBundleArray.getJSONObject(i).getString("DeveloperName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(auraDefinitionBundleArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlAuraDefinitionBundletype.appendChild(xmlAuraDefinitionBundleMembers);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				Element xmlAuraDefinitionBundleName = doc.createElement("name");
				xmlAuraDefinitionBundleName.appendChild(doc.createTextNode("AuraDefinitionBundle"));
				xmlAuraDefinitionBundletype.appendChild(xmlAuraDefinitionBundleName);
			}
		}

	}

	public void getAutoResponse(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray autoResponseArray = DataWarehouse.getAutoResponseList(loginObject, startdate, enddate, sfdcuserid);
		if (autoResponseArray != null) {
			if (autoResponseArray.length() > 0) {
				Element xmlautoResponseListtype = doc.createElement("types");
				xmlroot.appendChild(xmlautoResponseListtype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < autoResponseArray.length(); i++) {
					try {
						if(uniquecharset.add(autoResponseArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, autoResponseArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlautoResponseListMembers = doc.createElement("members");
						xmlautoResponseListMembers
								.appendChild(doc.createTextNode(autoResponseArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(autoResponseArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlautoResponseListtype.appendChild(xmlautoResponseListMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				Element xmlautoResponseListName = doc.createElement("name");
				xmlautoResponseListName.appendChild(doc.createTextNode("AutoResponseRule"));
				xmlautoResponseListtype.appendChild(xmlautoResponseListName);
			}
		}

	}

	public void getBusinessProcess(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray businessProcessArray = DataWarehouse.getBusinessProcessList(loginObject, startdate, enddate,
				sfdcuserid);
		if (businessProcessArray != null) {
			if (businessProcessArray.length() > 0) {
				Element xmlbusinessProcesstype = doc.createElement("types");
				xmlroot.appendChild(xmlbusinessProcesstype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < businessProcessArray.length(); i++) {
					try {
						if(uniquecharset.add(businessProcessArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, businessProcessArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlbusinessProcessMembers = doc.createElement("members");
						xmlbusinessProcessMembers.appendChild(
								doc.createTextNode(businessProcessArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(businessProcessArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlbusinessProcesstype.appendChild(xmlbusinessProcessMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlbusinessProcessName = doc.createElement("name");
				xmlbusinessProcessName.appendChild(doc.createTextNode("BusinessProcess"));
				xmlbusinessProcesstype.appendChild(xmlbusinessProcessName);
			}
		}

	}

	public void getCompactLayout(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray compactLayoutArray = DataWarehouse.getCompactLayoutList(loginObject, startdate, enddate, sfdcuserid);
		if (compactLayoutArray != null) {
			if (compactLayoutArray.length() > 0) {
				Element xmlcompactLayouttype = doc.createElement("types");
				xmlroot.appendChild(xmlcompactLayouttype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < compactLayoutArray.length(); i++) {
					try {
						if(uniquecharset.add(compactLayoutArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, compactLayoutArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlcompactLayoutMembers = doc.createElement("members");
						xmlcompactLayoutMembers.appendChild(
								doc.createTextNode(compactLayoutArray.getJSONObject(i).getString("SobjectType") + "."
										+ compactLayoutArray.getJSONObject(i).getString("DeveloperName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(compactLayoutArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlcompactLayouttype.appendChild(xmlcompactLayoutMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlcompactLayoutName = doc.createElement("name");
				xmlcompactLayoutName.appendChild(doc.createTextNode("CompactLayout"));
				xmlcompactLayouttype.appendChild(xmlcompactLayoutName);
			}
		}

	}

	public void getConnectedApplication(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray connectedApplicationArray = DataWarehouse.getConnectedApplicationList(loginObject, startdate, enddate,
				sfdcuserid);
		if (connectedApplicationArray != null) {
			if (connectedApplicationArray.length() > 0) {
				Element xmlconnectedApplicationtype = doc.createElement("types");
				xmlroot.appendChild(xmlconnectedApplicationtype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < connectedApplicationArray.length(); i++) {
					try {
						if(uniquecharset.add(connectedApplicationArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, connectedApplicationArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlconnectedApplicationMembers = doc.createElement("members");
						xmlconnectedApplicationMembers.appendChild(
								doc.createTextNode(connectedApplicationArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(connectedApplicationArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlconnectedApplicationtype.appendChild(xmlconnectedApplicationMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlconnectedApplicationName = doc.createElement("name");
				xmlconnectedApplicationName.appendChild(doc.createTextNode("ConnectedApplication"));
				xmlconnectedApplicationtype.appendChild(xmlconnectedApplicationName);
			}
		}

	}

	public void getCustomApplication(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray customApplicationArray = DataWarehouse.getCustomApplicationList(loginObject, startdate, enddate,
				sfdcuserid);
		if (customApplicationArray != null) {
			if (customApplicationArray.length() > 0) {
				Element xmlcustomApplicationtype = doc.createElement("types");
				xmlroot.appendChild(xmlcustomApplicationtype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < customApplicationArray.length(); i++) {
					try {
						if(uniquecharset.add(customApplicationArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, customApplicationArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlcustomApplicationMembers = doc.createElement("members");
						xmlcustomApplicationMembers.appendChild(
								doc.createTextNode(customApplicationArray.getJSONObject(i).getString("DeveloperName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(customApplicationArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlcustomApplicationtype.appendChild(xmlcustomApplicationMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlcustomApplicationName = doc.createElement("name");
				xmlcustomApplicationName.appendChild(doc.createTextNode("CustomApplication"));
				xmlcustomApplicationtype.appendChild(xmlcustomApplicationName);
			}
		}

	}

	public void getCustomObject(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray customobjectArray = DataWarehouse.getCustomObjectList(loginObject, startdate, enddate, sfdcuserid);
		if (customobjectArray != null) {
			if (customobjectArray.length() > 0) {
				Element xmlcustomobjecttype = doc.createElement("types");
				xmlroot.appendChild(xmlcustomobjecttype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < customobjectArray.length(); i++) {
					try {
						if(uniquecharset.add(customobjectArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, customobjectArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlcustomobjectMembers = doc.createElement("members");
						xmlcustomobjectMembers.appendChild(doc
								.createTextNode(customobjectArray.getJSONObject(i).getString("DeveloperName") + "__c"+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(customobjectArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlcustomobjecttype.appendChild(xmlcustomobjectMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				Element xmlcustomobjectName = doc.createElement("name");
				xmlcustomobjectName.appendChild(doc.createTextNode("CustomObject"));
				xmlcustomobjecttype.appendChild(xmlcustomobjectName);
			}
		}

	}

	public void getCustomField(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray customFieldArray = DataWarehouse.__getCustomFieldList(loginObject, startdate, enddate, sfdcuserid);
		if (customFieldArray != null) {
			if (customFieldArray.length() > 0) {
				Element xmlcustomfieldtype = doc.createElement("types");
				xmlroot.appendChild(xmlcustomfieldtype);
				HashSet < String> uniqueTableEnumOrId= new HashSet<String>();
				String customObjectName = "";
				String userfullname="";
				HashSet <String> uniqueset= new HashSet<String>();
				for (int j = 0; j < customFieldArray.length(); j++) {
					if (customFieldArray.getJSONObject(j).getString("TableEnumOrId").matches("^[A-Za-z]+[0-9]*"))
						customObjectName = customFieldArray.getJSONObject(j).getString("TableEnumOrId");
					else {
						if(uniqueTableEnumOrId.add(customFieldArray.getJSONObject(j).getString("TableEnumOrId")))
						{	
							customObjectName = DataWarehouse.getCustomObjectName(loginObject,customFieldArray.getJSONObject(j).getString("TableEnumOrId"));
							customObjectName += "__c";
						}
					}
					if(uniqueset.add(customFieldArray.getJSONObject(j).getString("LastModifiedById")))
						userfullname = DataWarehouse.getUserFullName(loginObject, customFieldArray.getJSONObject(j).getString("LastModifiedById"));
				
					Element xmlcustomfieldMembers = doc.createElement("members");
					xmlcustomfieldMembers.appendChild(doc.createTextNode(customObjectName + "."+ customFieldArray.getJSONObject(j).getString("DeveloperName") + "__c"+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(customFieldArray.getJSONObject(j).getString("LastModifiedDate"))));
					xmlcustomfieldtype.appendChild(xmlcustomfieldMembers);

				}

				Element xmlcustomfieldName = doc.createElement("name");
				xmlcustomfieldName.appendChild(doc.createTextNode("CustomField"));
				xmlcustomfieldtype.appendChild(xmlcustomfieldName);
			}
		}

	}


	public void getCustomTab(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray customTabArray = DataWarehouse.getCustomTabList(loginObject, startdate, enddate, sfdcuserid);
		if (customTabArray != null) {
			if (customTabArray.length() > 0) {
				Element xmlcustomTabtype = doc.createElement("types");
				xmlroot.appendChild(xmlcustomTabtype);
				String userfullname="";
				HashSet <String> uniqueset= new HashSet<String>();
				for (int i = 0; i < customTabArray.length(); i++) {
					try {
						JSONArray customTabFullname = DataWarehouse.getFullname("CustomTab",customTabArray.getJSONObject(i).getString("Id"), loginObject);
						if(uniqueset.add(customTabArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, customTabArray.getJSONObject(i).getString("LastModifiedById"));
					
						Element xmlcustomTabMembers = doc.createElement("members");
						xmlcustomTabMembers.appendChild(
								doc.createTextNode(customTabFullname.getJSONObject(0).getString("FullName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(customTabArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlcustomTabtype.appendChild(xmlcustomTabMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlcustomTabName = doc.createElement("name");
				xmlcustomTabName.appendChild(doc.createTextNode("CustomTab"));
				xmlcustomTabtype.appendChild(xmlcustomTabName);
			}
		}

	}

	public void getDashboard(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray dashboardArray = DataWarehouse.getDashboardList(loginObject, startdate, enddate, sfdcuserid);
		if (dashboardArray != null) {
			if (dashboardArray.length() > 0) {
				Element xmldashboardtype = doc.createElement("types");
				xmlroot.appendChild(xmldashboardtype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < dashboardArray.length(); i++) {
					try {
						if(uniquecharset.add(dashboardArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, dashboardArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmldashboardMembers = doc.createElement("members");
						xmldashboardMembers.appendChild(
								doc.createTextNode(dashboardArray.getJSONObject(i).getString("DeveloperName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(dashboardArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmldashboardtype.appendChild(xmldashboardMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmldashboardName = doc.createElement("name");
				xmldashboardName.appendChild(doc.createTextNode("Dashboard"));
				xmldashboardtype.appendChild(xmldashboardName);
			}
		}

	}

	public void getEmailTemplate(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray emailTemplateArray = DataWarehouse.getEmailTemplateList(loginObject, startdate, enddate, sfdcuserid);
		if (emailTemplateArray != null) {
			if (emailTemplateArray.length() > 0) {
				Element xmlemailTemplateListtype = doc.createElement("types");
				xmlroot.appendChild(xmlemailTemplateListtype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < emailTemplateArray.length(); i++) {
					try {
						if(uniquecharset.add(emailTemplateArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, emailTemplateArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlemailTemplateListMembers = doc.createElement("members");
						xmlemailTemplateListMembers
								.appendChild(doc.createTextNode(emailTemplateArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(emailTemplateArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlemailTemplateListtype.appendChild(xmlemailTemplateListMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlemailTemplateListName = doc.createElement("name");
				xmlemailTemplateListName.appendChild(doc.createTextNode("EmailTemplate"));
				xmlemailTemplateListtype.appendChild(xmlemailTemplateListName);
			}
		}

	}

	public void getFieldSet(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray fieldSetArray = DataWarehouse.getFieldSetList(loginObject, startdate, enddate, sfdcuserid);
		if (fieldSetArray != null) {
			if (fieldSetArray.length() > 0) {
				Element xmlfieldSettype = doc.createElement("types");
				xmlroot.appendChild(xmlfieldSettype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < fieldSetArray.length(); i++) {
					try {
						if(uniquecharset.add(fieldSetArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, fieldSetArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlfieldSetMembers = doc.createElement("members");
						xmlfieldSetMembers.appendChild(
								doc.createTextNode(fieldSetArray.getJSONObject(i).getString("DeveloperName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(fieldSetArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlfieldSettype.appendChild(xmlfieldSetMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlxmlfieldSetName = doc.createElement("name");
				xmlxmlfieldSetName.appendChild(doc.createTextNode("FieldSet"));
				xmlfieldSettype.appendChild(xmlxmlfieldSetName);
			}
		}

	}

	public void getFlexiPage(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray flexiPageArray = DataWarehouse.getFlexiPageList(loginObject, startdate, enddate, sfdcuserid);
		if (flexiPageArray != null) {
			if (flexiPageArray.length() > 0) {
				Element xmlflexiPageListtype = doc.createElement("types");
				xmlroot.appendChild(xmlflexiPageListtype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < flexiPageArray.length(); i++) {
					try {
						if(uniquecharset.add(flexiPageArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, flexiPageArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlflexiPageListMembers = doc.createElement("members");
						xmlflexiPageListMembers.appendChild(
								doc.createTextNode(flexiPageArray.getJSONObject(i).getString("DeveloperName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(flexiPageArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlflexiPageListtype.appendChild(xmlflexiPageListMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlflexiPageListName = doc.createElement("name");
				xmlflexiPageListName.appendChild(doc.createTextNode("FlexiPage"));
				xmlflexiPageListtype.appendChild(xmlflexiPageListName);
			}
		}

	}

	public void getFlow(JSONObject loginObject, String sfdcuserid, String startdate, String enddate) throws Exception {

		JSONArray flowArray = DataWarehouse.getFlowList(loginObject, startdate, enddate, sfdcuserid);
		if (flowArray != null) {
			if (flowArray.length() > 0) {
				Element xmlflowtype = doc.createElement("types");
				xmlroot.appendChild(xmlflowtype);
				String userfullname="";
				HashSet <String> uniqueset= new HashSet<String>();
				for (int i = 0; i < flowArray.length(); i++) {
					try {
						JSONArray flowFullname = DataWarehouse.getFullname("Flow",
								flowArray.getJSONObject(i).getString("Id"), loginObject);
						
						if(uniqueset.add(flowArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, flowArray.getJSONObject(i).getString("LastModifiedById"));
					
						Element xmlflowMembers = doc.createElement("members");
						xmlflowMembers
								.appendChild(doc.createTextNode(flowFullname.getJSONObject(0).getString("FullName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(flowArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlflowtype.appendChild(xmlflowMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlflowName = doc.createElement("name");
				xmlflowName.appendChild(doc.createTextNode("Flow"));
				xmlflowtype.appendChild(xmlflowName);
			}
		}

	}

	public void getGlobalValueSet(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray globalValueSetArray = DataWarehouse.getGlobalValueSetList(loginObject, startdate, enddate,
				sfdcuserid);
		if (globalValueSetArray != null) {
			if (globalValueSetArray.length() > 0) {
				Element xmlglobalValueSettype = doc.createElement("types");
				xmlroot.appendChild(xmlglobalValueSettype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < globalValueSetArray.length(); i++) {
					try {
						if(uniquecharset.add(globalValueSetArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, globalValueSetArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlglobalValueSetMembers = doc.createElement("members");
						xmlglobalValueSetMembers.appendChild(
								doc.createTextNode(globalValueSetArray.getJSONObject(i).getString("DeveloperName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(globalValueSetArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlglobalValueSettype.appendChild(xmlglobalValueSetMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlglobalValueSetName = doc.createElement("name");
				xmlglobalValueSetName.appendChild(doc.createTextNode("GlobalValueSet"));
				xmlglobalValueSettype.appendChild(xmlglobalValueSetName);
			}
		}

	}

	public void getHomePageLayout(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {
		JSONArray homePageLayoutArray = DataWarehouse.getHomePageLayoutList(loginObject, startdate, enddate,
				sfdcuserid);
		if (homePageLayoutArray != null) {
			if (homePageLayoutArray.length() > 0) {
				Element xmlhomePageLayouttype = doc.createElement("types");
				xmlroot.appendChild(xmlhomePageLayouttype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < homePageLayoutArray.length(); i++) {
					try {
						if(uniquecharset.add(homePageLayoutArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, homePageLayoutArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlhomePageLayoutMembers = doc.createElement("members");
						xmlhomePageLayoutMembers.appendChild(
								doc.createTextNode(homePageLayoutArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(homePageLayoutArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlhomePageLayouttype.appendChild(xmlhomePageLayoutMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlhomePageLayoutName = doc.createElement("name");
				xmlhomePageLayoutName.appendChild(doc.createTextNode("HomePageLayout"));
				xmlhomePageLayouttype.appendChild(xmlhomePageLayoutName);
			}
		}

	}

	public void getLayout(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray layoutArray = DataWarehouse.getLayoutList(loginObject, startdate, enddate, sfdcuserid);
		if (layoutArray != null) {
			if (layoutArray.length() > 0) {
				Element xmlcustomfieldtype = doc.createElement("types");
				xmlroot.appendChild(xmlcustomfieldtype);
				String userfullname="";
				HashSet <String> uniqueset= new HashSet<String>();
				HashSet <String> uniqueTableEnumOrId= new HashSet<String>();
				String customObjectName = "";
				for (int j = 0; j < layoutArray.length(); j++) {
					if (layoutArray.getJSONObject(j).getString("TableEnumOrId").matches("^[A-Za-z]+[0-9]*"))
						customObjectName = layoutArray.getJSONObject(j).getString("TableEnumOrId");
					else {
						if(uniqueTableEnumOrId.add(layoutArray.getJSONObject(j).getString("TableEnumOrId")))
						{
							customObjectName = DataWarehouse.getCustomObjectName(loginObject,layoutArray.getJSONObject(j).getString("TableEnumOrId"));
							customObjectName += "__c";
						}
					}
				
					if(uniqueset.add(layoutArray.getJSONObject(j).getString("LastModifiedById")))
						userfullname = DataWarehouse.getUserFullName(loginObject, layoutArray.getJSONObject(j).getString("LastModifiedById"));
				
					Element xmlcustomfieldMembers = doc.createElement("members");
					xmlcustomfieldMembers.appendChild(doc
							.createTextNode(customObjectName + "." + layoutArray.getJSONObject(j).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(layoutArray.getJSONObject(j).getString("LastModifiedDate"))));
					xmlcustomfieldtype.appendChild(xmlcustomfieldMembers);

				}

				Element xmlcustomfieldName = doc.createElement("name");
				xmlcustomfieldName.appendChild(doc.createTextNode("Layout"));
				xmlcustomfieldtype.appendChild(xmlcustomfieldName);
			}
		}

	}
	public void getPermission(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray permissionSetArray = DataWarehouse.getPermissionSetList(loginObject, startdate, enddate, sfdcuserid);
		if (permissionSetArray != null) {
			if (permissionSetArray.length() > 0) {
				Element xmlpermissionSettype = doc.createElement("types");
				xmlroot.appendChild(xmlpermissionSettype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < permissionSetArray.length(); i++) {
					try {
						if(uniquecharset.add(permissionSetArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, permissionSetArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlpermissionSetMembers = doc.createElement("members");
						xmlpermissionSetMembers
								.appendChild(doc.createTextNode(permissionSetArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(permissionSetArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlpermissionSettype.appendChild(xmlpermissionSetMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlpermissionSetName = doc.createElement("name");
				xmlpermissionSetName.appendChild(doc.createTextNode("PermissionSet"));
				xmlpermissionSettype.appendChild(xmlpermissionSetName);
			}
		}

	}

	public void getProfile(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray profileArray = DataWarehouse.getProfileList(loginObject, startdate, enddate, sfdcuserid);
		if (profileArray != null) {
			if (profileArray.length() > 0) {
				Element xmlprofiletype = doc.createElement("types");
				xmlroot.appendChild(xmlprofiletype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < profileArray.length(); i++) {
					try {
						if(uniquecharset.add(profileArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, profileArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlprofileMembers = doc.createElement("members");
						xmlprofileMembers
								.appendChild(doc.createTextNode(profileArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(profileArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlprofiletype.appendChild(xmlprofileMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlprofileName = doc.createElement("name");
				xmlprofileName.appendChild(doc.createTextNode("Profile"));
				xmlprofiletype.appendChild(xmlprofileName);
			}
		}

	}

	public void getRecordType(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray recordTypeArray = DataWarehouse.getRecordTypeList(loginObject, startdate, enddate, sfdcuserid);
		if (recordTypeArray != null) {
			if (recordTypeArray.length() > 0) {
				Element xmlrecordTypetype = doc.createElement("types");
				xmlroot.appendChild(xmlrecordTypetype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < recordTypeArray.length(); i++) {
					try {
						if(uniquecharset.add(recordTypeArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, recordTypeArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlrecordTypeMembers = doc.createElement("members");
						xmlrecordTypeMembers
								.appendChild(doc.createTextNode(recordTypeArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(recordTypeArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlrecordTypetype.appendChild(xmlrecordTypeMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlrecordTypeName = doc.createElement("name");
				xmlrecordTypeName.appendChild(doc.createTextNode("RecordType"));
				xmlrecordTypetype.appendChild(xmlrecordTypeName);
			}
		}

	}

	public void getReport(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray reportArray = DataWarehouse.getReportList(loginObject, startdate, enddate, sfdcuserid);
		if (reportArray != null) {
			if (reportArray.length() > 0) {
				Element xmlreporttype = doc.createElement("types");
				xmlroot.appendChild(xmlreporttype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < reportArray.length(); i++) {
					try {
						if(uniquecharset.add(reportArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, reportArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlreportMembers = doc.createElement("members");
						xmlreportMembers.appendChild(
								doc.createTextNode(reportArray.getJSONObject(i).getString("DeveloperName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(reportArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlreporttype.appendChild(xmlreportMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlreportName = doc.createElement("name");
				xmlreportName.appendChild(doc.createTextNode("Report"));
				xmlreporttype.appendChild(xmlreportName);
			}
		}

	}

	public void getStaticResources(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {
		JSONArray staticResourceArray = DataWarehouse.getStaticResourceList(loginObject, startdate, enddate,
				sfdcuserid);
		if (staticResourceArray != null) {
			if (staticResourceArray.length() > 0) {
				Element xmlstaticResourcetype = doc.createElement("types");
				xmlroot.appendChild(xmlstaticResourcetype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < staticResourceArray.length(); i++) {
					try {
						if(uniquecharset.add(staticResourceArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, staticResourceArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlstaticResourceMembers = doc.createElement("members");
						xmlstaticResourceMembers.appendChild(
								doc.createTextNode(staticResourceArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(staticResourceArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlstaticResourcetype.appendChild(xmlstaticResourceMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlstaticResourceName = doc.createElement("name");
				xmlstaticResourceName.appendChild(doc.createTextNode("StaticResource"));
				xmlstaticResourcetype.appendChild(xmlstaticResourceName);
			}
		}

	}

	public void getUser(JSONObject loginObject, String sfdcuserid, String startdate, String enddate) throws Exception {

		JSONArray UserArray = DataWarehouse.getUserList(loginObject, startdate, enddate, sfdcuserid);
		if (UserArray != null) {
			if (UserArray.length() > 0) {
				Element xmlUserType = doc.createElement("types");
				xmlroot.appendChild(xmlUserType);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < UserArray.length(); i++) {
					try {
						if(uniquecharset.add(UserArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, UserArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlUserMembers = doc.createElement("members");
						xmlUserMembers.appendChild(doc.createTextNode(UserArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(UserArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlUserType.appendChild(xmlUserMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlUserName = doc.createElement("name");
				xmlUserName.appendChild(doc.createTextNode("User"));
				xmlUserType.appendChild(xmlUserName);
			}
		}

	}

	public void getValidationRule(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray validationRuleArray = DataWarehouse.getValidationRuleList(loginObject, startdate, enddate,
				sfdcuserid);
		if (validationRuleArray != null) {
			if (validationRuleArray.length() > 0) {
				Element xmlvalidationRuletype = doc.createElement("types");
				xmlroot.appendChild(xmlvalidationRuletype);
				String userfullname="";
				HashSet <String> uniqueset= new HashSet<String>();
				for (int i = 0; i < validationRuleArray.length(); i++) {
					try {
					String objectname = DataWarehouse.getValidationRuleObjectName(loginObject,validationRuleArray.getJSONObject(i).getString("Id"));
					if(uniqueset.add(validationRuleArray.getJSONObject(i).getString("LastModifiedById")))
						userfullname = DataWarehouse.getUserFullName(loginObject, validationRuleArray.getJSONObject(i).getString("LastModifiedById"));
				
					Element xmlvalidationRuleMembers = doc.createElement("members");
						xmlvalidationRuleMembers.appendChild(doc.createTextNode(objectname+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(validationRuleArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlvalidationRuletype.appendChild(xmlvalidationRuleMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlvalidationRuleName = doc.createElement("name");
				xmlvalidationRuleName.appendChild(doc.createTextNode("ValidationRule"));
				xmlvalidationRuletype.appendChild(xmlvalidationRuleName);
			}
		}

	}


	public void getWebLink(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray WebLinArray = DataWarehouse.geWebLinkList(loginObject, startdate, enddate, sfdcuserid);
		if (WebLinArray != null) {
			if (WebLinArray.length() > 0) {
				Element xmlWebLinkType = doc.createElement("types");
				xmlroot.appendChild(xmlWebLinkType);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < WebLinArray.length(); i++) {
					try {
						if(uniquecharset.add(WebLinArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, WebLinArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlWebLinkMembers = doc.createElement("members");
						xmlWebLinkMembers
								.appendChild(doc.createTextNode(WebLinArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(WebLinArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlWebLinkType.appendChild(xmlWebLinkMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlWebLinkName = doc.createElement("name");
				xmlWebLinkName.appendChild(doc.createTextNode("WebLink"));
				xmlWebLinkType.appendChild(xmlWebLinkName);
			}
		}

	}

	public void getWorkFlowAlert(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray objWorkFlowAlert = DataWarehouse.getWorkflowAlertList(loginObject, startdate, enddate, sfdcuserid);
		if (objWorkFlowAlert != null) {
			if (objWorkFlowAlert.length() > 0) {
				Element xmlobjWorkFlowAlerttype = doc.createElement("types");
				xmlroot.appendChild(xmlobjWorkFlowAlerttype);
				try {
					String userfullname="";
					HashSet <String> uniqueset= new HashSet<String>();
					for (int k = 0; k < objWorkFlowAlert.length(); k++) {
						JSONArray jsonworkflowaler = DataWarehouse.getFullname("WorkFlowAlert",
								objWorkFlowAlert.getJSONObject(k).getString("Id"), loginObject);
						
						if(uniqueset.add(objWorkFlowAlert.getJSONObject(k).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, objWorkFlowAlert.getJSONObject(k).getString("LastModifiedById"));
					
						Element xmlobjworkFlowAlertMembers = doc.createElement("members");
						xmlobjworkFlowAlertMembers.appendChild(
								doc.createTextNode(jsonworkflowaler.getJSONObject(0).getString("FullName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(objWorkFlowAlert.getJSONObject(k).getString("LastModifiedDate"))));
						xmlobjWorkFlowAlerttype.appendChild(xmlobjworkFlowAlertMembers);

					}
					Element xmlobjWorkFlowAlertName = doc.createElement("name");
					xmlobjWorkFlowAlertName.appendChild(doc.createTextNode("WorkFlowAlert"));
					xmlobjWorkFlowAlerttype.appendChild(xmlobjWorkFlowAlertName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}


	public void getWorkFlowFieldUpdate(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray workflowFieldUpdateArray = DataWarehouse.getWorkflowFieldUpdateList(loginObject, startdate, enddate,
				sfdcuserid);
		if (workflowFieldUpdateArray != null) {
			if (workflowFieldUpdateArray.length() > 0) {
				Element xmlworkflowFieldUpdatetype = doc.createElement("types");
				xmlroot.appendChild(xmlworkflowFieldUpdatetype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < workflowFieldUpdateArray.length(); i++) {
					try {
						if(uniquecharset.add(workflowFieldUpdateArray.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, workflowFieldUpdateArray.getJSONObject(i).getString("LastModifiedById"));
						Element xmlworkflowFieldUpdateMembers = doc.createElement("members");
						xmlworkflowFieldUpdateMembers.appendChild(doc.createTextNode(
								workflowFieldUpdateArray.getJSONObject(i).getString("SourceTableEnumOrId") + "."
										+ workflowFieldUpdateArray.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(workflowFieldUpdateArray.getJSONObject(i).getString("LastModifiedDate"))));
						xmlworkflowFieldUpdatetype.appendChild(xmlworkflowFieldUpdateMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlworkflowFieldUpdateName = doc.createElement("name");
				xmlworkflowFieldUpdateName.appendChild(doc.createTextNode("WorkflowFieldUpdate"));
				xmlworkflowFieldUpdatetype.appendChild(xmlworkflowFieldUpdateName);
			}
		}

	}

	public void getWorkFlowRule(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray workflowRuleList = DataWarehouse.getWorkflowRuleList(loginObject, startdate, enddate, sfdcuserid);
		if (workflowRuleList != null) {
			if (workflowRuleList.length() > 0) {
				Element xmlworkflowRuletype = doc.createElement("types");
				xmlroot.appendChild(xmlworkflowRuletype);
				String userfullname="";
				HashSet <String> uniquecharset= new HashSet<String>();
				for (int i = 0; i < workflowRuleList.length(); i++) {
					try {
						if(uniquecharset.add(workflowRuleList.getJSONObject(i).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, workflowRuleList.getJSONObject(i).getString("LastModifiedById"));
						Element xmlworkflowRuleMembers = doc.createElement("members");
						xmlworkflowRuleMembers.appendChild(
								doc.createTextNode(workflowRuleList.getJSONObject(i).getString("TableEnumOrId") + "."
										+ workflowRuleList.getJSONObject(i).getString("Name")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(workflowRuleList.getJSONObject(i).getString("LastModifiedDate"))));
						xmlworkflowRuletype.appendChild(xmlworkflowRuleMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlworkflowRuleName = doc.createElement("name");
				xmlworkflowRuleName.appendChild(doc.createTextNode("WorkflowRule"));
				xmlworkflowRuletype.appendChild(xmlworkflowRuleName);
			}
		}

	}

	public void getWorkFlowTask(JSONObject loginObject, String sfdcuserid, String startdate, String enddate)
			throws Exception {

		JSONArray objWorkFlowTask = DataWarehouse.getWorkflowTaskList(loginObject, startdate, enddate, sfdcuserid);
		if (objWorkFlowTask != null) {
			if (objWorkFlowTask.length() > 0) {
				Element xmlobjWorkFlowTasktype = doc.createElement("types");
				xmlroot.appendChild(xmlobjWorkFlowTasktype);
				try {
					String userfullname="";
					HashSet <String> uniqueset= new HashSet<String>();
					for (int k = 0; k < objWorkFlowTask.length(); k++) {
						JSONArray jsonworkflowaler = DataWarehouse.getFullname("WorkFlowTask",
								objWorkFlowTask.getJSONObject(k).getString("Id"), loginObject);
						if(uniqueset.add(objWorkFlowTask.getJSONObject(k).getString("LastModifiedById")))
							userfullname = DataWarehouse.getUserFullName(loginObject, objWorkFlowTask.getJSONObject(k).getString("LastModifiedById"));
					
						Element xmlobjWorkFlowTaskMembers = doc.createElement("members");
						xmlobjWorkFlowTaskMembers.appendChild(
								doc.createTextNode(jsonworkflowaler.getJSONObject(0).getString("FullName")+"###"+userfullname+"###"+RestResourceURL.getSuffixDate(objWorkFlowTask.getJSONObject(k).getString("LastModifiedDate"))));
						xmlobjWorkFlowTasktype.appendChild(xmlobjWorkFlowTaskMembers);

					}
					Element xmlobjWorkFlowTaskName = doc.createElement("name");
					xmlobjWorkFlowTaskName.appendChild(doc.createTextNode("WorkFlowTask"));
					xmlobjWorkFlowTasktype.appendChild(xmlobjWorkFlowTaskName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}


	public File saveXml() throws TransformerException {
		
		File file = XmlDocumetRes.xmlDocEnd(doc, xmlroot);
		return file;
	}
}