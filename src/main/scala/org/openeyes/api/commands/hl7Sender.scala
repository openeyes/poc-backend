package org.openeyes.api.commands

import ca.uhn.hl7v2.DefaultHapiContext

object hl7Sender {
  val msg="MSH|^~\\&|PAS|RCB|ROUTE|ROUTE|201010101418||ADT^A01^ADT_A01|1391320453338055|P|2.4|1|20101010141857|||GBR|UNICODE|EN||iTKv1.0\rEVN||201010101400|||111111111^Cortana^Emily^^^Miss^^RCB55|201010101400\rPID|1||3333333333^^^NHS||SMITH^FREDRICA^J^^MRS^^L|SCHMIDT^HELGAR^Y|196512131515|2|||29 WEST AVENUE^BURYTHORPE^MALTON^NORTH YORKSHIRE^YO32 5TT^GBR^H||+441234567890||EN|M|C22|||||A|Berlin|||GBR||DEU\rPD1|||MALTON GP PRACTICE^^Y06601|G5612908^Townley^Gregory^^^Dr^^^GMC\rNK1|1|SMITH^ALBERT^J^^MR^^L|1|29 WEST AVENUE^BURYTHORPE^MALTON^NORTH YORKSHIRE^YO32 5TT^GBR^H|+441234567890||||||||||1|196311111513||||EN\rPV1|1|I|RCB^OBS1^BAY2-6^RCB55|13|||C3456789^Darwin^Samuel^^^Dr^^^GMC|G5612908^Townley^Gregory^^^Dr^^^GMC|C3456789^Darwin^Samuel^^^Dr^^^GMC|300||||19|||||2139^^^VISITID|||||||||||||||||||||||||201010201716\rPV2||||||||||||||||||||||||||||||||||||||C\rAL1|1|DA|Z88.5|5||199807011755\rDG1|1||N39.3^Stress Incontinence^ICD10||201010090900|A|||||||||1|C3456789^Darwin^Samuel^^^Dr^^^GMC|D|N|201010090900\rPR1|1||ZZS4^Colonic examination^OPCS4||201010202056|D|34|||||C3456789^Darwin^Samuel^^^Dr^^^GMC|C3||N39.3\rZU1|201010071234|1|C|201010091300||500|||||||||201010081200|201010081156|02|Y|0\rZU3|004|03|5|||||Normal|8b||1|1\rZU4||201010081756|201010090000\rZU8|Z|1|No"

  def apply() = {
    val context = new DefaultHapiContext
    context.setValidationContext("ca.uhn.hl7v2.validation.impl.NoValidation")
    val connection = context.newClient("localhost", 10110, false)
    connection.getInitiator.sendAndReceive(context.getPipeParser.parse(msg))
    connection.close
  }
}