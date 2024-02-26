def distanceEstimate(NVn: NVnum): num {
    nfold(min, NVn + NVsenseDist, Infinity)
}


def distanceTo(src: bool): num {
    exchange(Infinity, (NVn) => retsend mux(src, 0, distanceEstimate(NVn)))
}
