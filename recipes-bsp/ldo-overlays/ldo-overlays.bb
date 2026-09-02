SUMMARY = "LDO Raspberry Pi display device-tree overlays"

LICENSE = "CLOSED"

SRC_URI = "\
    file://ldo_35dpi_3b4b.dtbo \
    file://ldo_35dpi_3b.dtbo \
    file://ldo_35dpi_4b.dtbo \
"

S = "${UNPACKDIR}"

inherit deploy

do_deploy() {
    install -d ${DEPLOYDIR}/overlays

    install -m 0644 ${UNPACKDIR}/ldo_35dpi_3b4b.dtbo \
        ${DEPLOYDIR}/overlays/

    install -m 0644 ${UNPACKDIR}/ldo_35dpi_3b.dtbo \
        ${DEPLOYDIR}/overlays/

    install -m 0644 ${UNPACKDIR}/ldo_35dpi_4b.dtbo \
        ${DEPLOYDIR}/overlays/
}

addtask deploy after do_unpack before do_build

do_install() {
    install -d ${D}/boot/overlays
    install -m 0644 ${UNPACKDIR}/*.dtbo ${D}/boot/overlays/
}

FILES:${PN} += "/boot/overlays/*.dtbo"

