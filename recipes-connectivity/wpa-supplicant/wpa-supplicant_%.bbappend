FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://wpa_supplicant.conf-jdm"

do_install:append () {
        install -m 600 ${UNPACKDIR}/wpa_supplicant.conf-jdm ${D}${sysconfdir}/wpa_supplicant.conf
}
