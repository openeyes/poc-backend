package org.openeyes.api.forms

import jp.sf.amateras.scalatra.forms._
import org.openeyes.api.stacks.com.constructiveproof.remotable.stacks.LoggerStack
import org.scalatra.i18n.I18nSupport
import org.scalatra.json.JacksonJsonSupport
import org.scalatra.servlet.ServletBase


/**
 * Created by dave on 19/08/2014.
 */
trait ObservationFormSupport extends ClientSideValidationFormSupport with LoggerStack {
  self: ServletBase with I18nSupport with JacksonJsonSupport =>

  case class ObservationForm(weight: Int)

  val observationForm = mapping(
    "weight" -> number(required)
  )(ObservationForm.apply)
}