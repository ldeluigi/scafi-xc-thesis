//! @brief Computes the distance from a source with a custom metric through adaptive bellmann-ford.
template <typename node_t, typename G, typename = common::if_signature<G, field<real_t>()>>
real_t abf_distance(node_t& node, trace_t call_point, bool source, G&& metric) {
    internal::trace_call trace_caller(node.stack_trace, call_point);

    return nbr(node, 0, INF, [&] (field<real_t> d) {
        return min_hood(node, 0, d + metric(), source ? 0 : INF);
    });
}
