package com.rider.folly.json.enums;

/**
 * The RUNNER_METADATA returned by listMarketCatalogue for Horse Racing (when
 * available)
 *
 * @author Ciaron Rider
 */
public enum RunnerMetadatum {
    /**
     * The unit of weight used.
     */
    WEIGHT_UNITS,
    /**
     * Adjusted ratings are race-specific ratings which reflect weights
     * allocated in the race and, in some circumstances, the age of the horse.
     * Collectively they represent the chance each runner has on form.
     * https://www.timeform.com/Racing/Articles/How_the_ratings_for_a_race_are_calculated
     * Please note: this data is only returned for those with a Premium Timeform
     * subscription
     */
    ADJUSTED_RATING,
    /**
     * The year the horse’s mother's birth
     */
    DAM_YEAR_BORN,
    /**
     * The number of days since the horse last ran
     */
    DAYS_SINCE_LAST_RUN,
    /**
     * Any extra equipment the horse is wearing
     */
    WEARING,
    /**
     * The year in which the horse's grandfather was born on its mothers side
     */
    DAMSIRE_YEAR_BORN,
    /**
     * The country were the horse's father was bred
     */
    SIRE_BRED,
    /**
     * The name of the horse's trainer
     */
    TRAINER_NAME,
    /**
     * The stall number the horse is starting from
     */
    STALL_DRAW,
    /**
     * The sex of the horse
     */
    SEX_TYPE,
    /**
     * The owner of the horse
     */
    OWNER_NAME,
    /**
     * The name of the horse's father
     */
    SIRE_NAME,
    /**
     * The forecast price numerator
     */
    FORECASTPRICE_NUMERATOR,
    /**
     * The forecast price denominator
     */
    FORECASTPRICE_DENOMINATOR,
    /**
     * The reduction in the weight that the horse carries for a particular
     * jockey were applicable.
     */
    JOCKEY_CLAIM,
    /**
     * The weight of the horse
     */
    WEIGHT_VALUE,
    /**
     * The name of the horse's mother
     */
    DAM_NAME,
    /**
     * The age of the horse
     */
    AGE,
    /**
     * The colour of the horse
     */
    COLOUR_TYPE,
    /**
     * The country were the horse's grandfather was born
     */
    DAMSIRE_BRED,
    /**
     * The name of the horse's grandfather
     */
    DAMSIRE_NAME,
    /**
     * The year the horse's father was born
     */
    SIRE_YEAR_BORN,
    /**
     * The horses official rating
     */
    OFFICIAL_RATING,
    /**
     * The horses recent form
     */
    FORM,
    /**
     * The country in which the horse was born
     */
    BRED,
    /**
     * The runnerId for the horse
     */
    runnerId,
    /**
     * The name of the jockey. Please note: This field will contain 'Reserve' in
     * the event that the horse has been entered into the market as a reserve
     * runner. Any reserve runners will be withdrawn from the market once it has
     * been confirmed that they will not run.
     */
    JOCKEY_NAME,
    /**
     * The country where the horse's mother was born
     */
    DAM_BRED,
    /**
     * The textual description of the jockey silk
     */
    COLOURS_DESCRIPTION,
    /**
     * A relative URL to an image file corresponding to the jockey silk. You
     * must add the value of this field to the base URL:
     * http://content-cache.betfair.com/feeds_images/Horses/SilkColours/ Please
     * note - silk cloth images aren't provided for US Racing
     */
    COLOURS_FILENAME,
    /**
     * The number on the saddle-cloth
     */
    CLOTH_NUMBER,
    /**
     * The number on the saddle-cloth. For US Racing were the runner is paired,
     * this field will display the cloth number of the paired runner e.g. "1A"
     */
    CLOTH_NUMBER_ALPHA

}
