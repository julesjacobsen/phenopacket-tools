package org.phenopackets.phenotools.builder.builders;

import com.google.protobuf.Timestamp;
import org.phenopackets.schema.v2.core.*;

import java.util.List;

import static org.phenopackets.phenotools.builder.builders.OntologyClassBuilder.ontologyClass;

/**
 * An Individual in the version 2 phenopacket can have these attributes. Only the id is required.
 * <ol>
 *      <li>id (string)</li>
 *      <li>alternate_ids (a list)</li>
 *      <li>date_of_birth (timestamp)</li>
 *      <li>time_at_last_encounter (TimeElement) </li>
 *      <li>vital_status (VitalStatus)</li>
 *      <li>sex (Sex)</li>
 *      <li>karyotypic_sex (KaryotypicSex)</li>
 *      <li>taxonomy (Ontology term)</li>
 * </ol>
 * @author Peter N Robinson
 */
public class IndividualBuilder {

    public static final OntologyClass HOMO_SAPIENS = ontologyClass("NCBI:txid9606", "Homo sapiens");

    private final Individual.Builder builder;

    private IndividualBuilder(String id) {
        builder = Individual.newBuilder().setId(id);
    }

    public static Individual individual(String id) {
        return Individual.newBuilder().setId(id).build();
    }

    public static IndividualBuilder create(String id) {
        return new IndividualBuilder(id);
    }

    public IndividualBuilder alternateId(String altId) {
        builder.addAlternateIds(altId);
        return this;
    }

    public IndividualBuilder alternateId(List<String> altIdList) {
        builder.addAllAlternateIds(altIdList);
        return this;
    }

    public IndividualBuilder dateOfBirth(String dobirth) {
        Timestamp dob = TimestampBuilder.fromISO8601(dobirth);
        builder.setDateOfBirth(dob);
        return this;
    }

    public IndividualBuilder timestampAtLastEncounter(String timestamp) {
        TimeElement t = TimeElements.timestamp(timestamp);
        builder.setTimeAtLastEncounter(t);
        return this;
    }
    public IndividualBuilder ageAtLastEncounter(String iso8601) {
        TimeElement t = TimeElements.age(iso8601);
        builder.setTimeAtLastEncounter(t);
        return this;
    }

    public IndividualBuilder alive() {
        VitalStatus status = VitalStatus.newBuilder().setStatus(VitalStatus.Status.ALIVE).build();
        builder.setVitalStatus(status);
        return this;
    }

    public IndividualBuilder deceased() {
        VitalStatus status = VitalStatus.newBuilder().setStatus(VitalStatus.Status.DECEASED).build();
        builder.setVitalStatus(status);
        return this;
    }

    public IndividualBuilder vitalStatus(VitalStatus status) {
        builder.setVitalStatus(status);
        return this;
    }

    public IndividualBuilder male() {
        builder.setSex(Sex.MALE);
        return this;
    }

    public IndividualBuilder female() {
        builder.setSex(Sex.FEMALE);
        return this;
    }

    public IndividualBuilder XX() {
        builder.setKaryotypicSex(KaryotypicSex.XX);
        return this;
    }

    public IndividualBuilder XY() {
        builder.setKaryotypicSex(KaryotypicSex.XY);
        return this;
    }

    public IndividualBuilder XO() {
        builder.setKaryotypicSex(KaryotypicSex.XO);
        return this;
    }

    public IndividualBuilder XXY() {
        builder.setKaryotypicSex(KaryotypicSex.XXY);
        return this;
    }

    public IndividualBuilder XXX() {
        builder.setKaryotypicSex(KaryotypicSex.XXX);
        return this;
    }

    public IndividualBuilder XXYY() {
        builder.setKaryotypicSex(KaryotypicSex.XXYY);
        return this;
    }

    public IndividualBuilder XXXY() {
        builder.setKaryotypicSex(KaryotypicSex.XXXY);
        return this;
    }

    public IndividualBuilder XXXX() {
        builder.setKaryotypicSex(KaryotypicSex.XXXX);
        return this;
    }

    public IndividualBuilder taxonomy(OntologyClass taxon) {
        builder.setTaxonomy(taxon);
        return this;
    }

    public IndividualBuilder homoSapiens() {
        builder.setTaxonomy(HOMO_SAPIENS);
        return this;
    }

    public Individual build() {
        return builder.build();
    }
}